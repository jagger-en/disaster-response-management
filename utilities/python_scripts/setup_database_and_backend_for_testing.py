#!/usr/bin/env python3
import docker
import signal
import sys
import time
import populate_database as pdb
from lib.application_handler import ApplicationHandler
from lib.logger import create_stdout_logger, create_file_logger


BACKEND_LOG_FILE = 'backend-test.log'
DB_INSTANCE = "postgres_instance"
logger = create_stdout_logger(f"{__name__}-logger")
main_logger = create_stdout_logger(f"{__name__}-main-logger")
backend_logger = create_file_logger(f"{__name__}-backend-logger", BACKEND_LOG_FILE)


if __name__ == "__main__":
    # Clear backend.log
    with open(BACKEND_LOG_FILE, 'w') as f:
        f.write('')

    docker_client = docker.from_env()
    application_handler = ApplicationHandler(
        db_instance=DB_INSTANCE,
        docker_client=docker_client,
        main_logger=main_logger,
        backend_logger=backend_logger)

    application_handler.run_db()
    # TODO: implement a wait_until mechanism instead of sleeping
    time.sleep(2)
    application_handler.add_stored_procedures()
    application_handler.run_backend()

    def ctrl_c_handler(sig, frame):
        application_handler.close()
        sys.exit(0)

    signal.signal(signal.SIGINT, ctrl_c_handler)

    pdb.populate_database_with_test_data()

    logger.info("listening...")
    while True:
        time.sleep(5)
