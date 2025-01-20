#!/usr/bin/env python3
import docker
import signal
import sys
import logging
import time
import subprocess
import os
import threading
import requests
import populate_database as pdb

logger = logging.getLogger(__name__)
streamHandler = logging.StreamHandler(stream=sys.stdout)
streamHandler.setLevel(logging.INFO)
streamHandler.setFormatter(logging.Formatter(fmt="%(asctime)s [%(levelname)s] %(message)s"))
logger.addHandler(streamHandler)
logger.setLevel(logging.INFO)

with open('backend.log', 'w') as f:
    f.write('')
anotherLogger = logging.getLogger("file_logger")
fileHandler = logging.FileHandler(filename="backend.log")
fileHandler.setLevel(logging.INFO)
fileHandler.setFormatter(logging.Formatter(fmt="%(asctime)s [%(levelname)s] %(message)s"))
anotherLogger.addHandler(fileHandler)
anotherLogger.setLevel(logging.INFO)

POSTGRES_INSTANCE = "postgres_instance"

class ApplicationHandler:

    def __init__(self, db_instance, docker_client):
        self.db_instance = db_instance
        self.docker_client = docker_client

    def run_db(self):
        logger.info(f"Running container {self.db_instance}")
        self.docker_client.containers.run(
            auto_remove=True,
            remove=True,
            name=POSTGRES_INSTANCE,
            environment=[
                "POSTGRES_USER=postgres",
                "POSTGRES_PASSWORD=root",
                "POSTGRES_DB=db_palapa",
            ],
            ports={'5432': 5432},
            image="docker.io/library/postgres:15.3",
            detach=True,
        )

    def add_stored_procedures(self):
        with open("./resources/sql/stored_procedures.sql", "r") as f:
            sql_commands = f.read()

            postgres_container = self.docker_client.containers.get(self.db_instance)
            _, output = postgres_container.exec_run(
                cmd=["psql", "-U", "postgres", "--dbname", "db_palapa", "--command", sql_commands],
            )

            for line in output.decode().splitlines():
                logger.info(line)

    def run_backend(self):
        current_directory = os.getcwd()
        os.chdir("./backend")

        mvn_process = subprocess.Popen(["./mvnw", "spring-boot:run"], stdout=subprocess.PIPE, stderr=subprocess.PIPE)

        os.chdir(current_directory)

        MAX_RETRIES = 10

        def backend_endpoint_checker():
            for _ in range(MAX_RETRIES):
                try:
                    requests.get("http://localhost:8081")

                    break
                except:
                    logger.info(f"backend not ready yet")
                    time.sleep(1)

        backend_endpoint_checker_thread = threading.Thread(target=backend_endpoint_checker)
        backend_endpoint_checker_thread.start()
        backend_endpoint_checker_thread.join()

        def backend_logs_writer():
            for line in mvn_process.stdout:
                anotherLogger.info(line.decode().strip())

        backend_logs_writer_thread = threading.Thread(target=backend_logs_writer)
        backend_logs_writer_thread.start()

        return mvn_process


docker_client = docker.from_env()
application_handler = ApplicationHandler(POSTGRES_INSTANCE, docker_client)

application_handler.run_db()
# TODO: implement a wait_until mechanism instead of sleeping
time.sleep(2)
application_handler.add_stored_procedures()

db_container = docker_client.containers.get(application_handler.db_instance)
backend_process = application_handler.run_backend()

def ctrl_c_handler(sig, frame):
    logger.info(f"Stopping db_container")
    db_container.stop()

    logger.info(f"Stopping backend_process")
    backend_process.terminate()

    sys.exit(0)

signal.signal(signal.SIGINT, ctrl_c_handler)

pdb.populate_database()

logger.info("listening...")
while True:
    time.sleep(5)
