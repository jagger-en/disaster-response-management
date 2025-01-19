#!/usr/bin/env python3
import docker
import signal
import sys
import logging
import time

logger = logging.getLogger(__name__)
streamHandler = logging.StreamHandler(stream=sys.stdout)
streamHandler.setLevel(logging.INFO)
streamHandler.setFormatter(logging.Formatter(fmt="%(asctime)s [%(levelname)s] %(message)s"))
logger.addHandler(streamHandler)
logger.setLevel(logging.INFO)

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

docker_client = docker.from_env()
application_handler = ApplicationHandler(POSTGRES_INSTANCE, docker_client)

application_handler.run_db()

# TODO: implement a wait_until mechanism instead of sleeping
time.sleep(2)
application_handler.add_stored_procedures()

db_container = docker_client.containers.get(application_handler.db_instance)

def ctrl_c_handler(sig, frame):
    logger.info(f"Stopping db_container")
    db_container.stop()

    sys.exit(0)

signal.signal(signal.SIGINT, ctrl_c_handler)

while True:
    logger.info("listening...")
    time.sleep(5)
