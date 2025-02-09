import time
import subprocess
import os
import threading
import requests

DATABASE_PORT = 5432 # This is hardcoded in the backend.
BACKEND_PORT = 8081 # This is hardcoded in the backend.

class ApplicationHandler:
    def __init__(self, db_instance, docker_client, main_logger, backend_logger):
        self.db_instance = db_instance
        self.docker_client = docker_client
        self.main_logger = main_logger
        self.backend_logger = backend_logger
        self.db_container = None
        self.backend_process = None

    def run_db(self):
        self.main_logger.info(f"Running container {self.db_instance}")
        self.docker_client.containers.run(
            auto_remove=True,
            remove=True,
            name=self.db_instance,
            environment=[
                "POSTGRES_USER=postgres",
                "POSTGRES_PASSWORD=root",
                "POSTGRES_DB=db_palapa",
            ],
            ports={'5432': DATABASE_PORT},
            image="docker.io/library/postgres:15.3",
            detach=True,
        )

        self.db_container = self.docker_client.containers.get(self.db_instance)

    def add_stored_procedures(self):
        with open("./resources/sql/stored_procedures.sql", "r") as f:
            sql_commands = f.read()

            postgres_container = self.docker_client.containers.get(self.db_instance)
            _, output = postgres_container.exec_run(
                cmd=["psql", "-U", "postgres", "--dbname", "db_palapa", "--command", sql_commands],
            )

            for line in output.decode().splitlines():
                self.main_logger.info(line)

    def run_backend(self):
        current_directory = os.getcwd()
        os.chdir("./backend")

        mvn_process = subprocess.Popen(["./mvnw", "spring-boot:run"], stdout=subprocess.PIPE, stderr=subprocess.PIPE)

        os.chdir(current_directory)

        MAX_RETRIES = 10

        def backend_endpoint_checker():
            for _ in range(MAX_RETRIES):
                try:
                    requests.get(f"http://localhost:{BACKEND_PORT}")

                    break
                except:
                    self.main_logger.info(f"backend not ready yet")
                    time.sleep(1)

        backend_endpoint_checker_thread = threading.Thread(target=backend_endpoint_checker)
        backend_endpoint_checker_thread.start()
        backend_endpoint_checker_thread.join()

        def backend_logs_writer():
            for line in mvn_process.stdout:
                self.backend_logger.info(line.decode().strip())

        backend_logs_writer_thread = threading.Thread(target=backend_logs_writer)
        backend_logs_writer_thread.start()

        self.backend_process = mvn_process

    def close(self):
        if self.db_container:
            self.main_logger.info(f"Stopping db_container")
            self.db_container.stop()

        if self.backend_process:
            self.main_logger.info(f"Stopping backend_process")
            self.backend_process.terminate()
