#!/usr/bin/env python3
import docker
import signal
import sys
import logging

logger = logging.getLogger(__name__)
streamHandler = logging.StreamHandler(stream=sys.stdout)
logger.addHandler(streamHandler)
logger.setLevel(logging.INFO)
streamHandler.setLevel(logging.INFO)

POSTGRES_INSTANCE = "postgres_instance"

def signal_handler(sig, frame):
    logger.info(f"Stopping container {POSTGRES_INSTANCE}")
    postgres_container = client.containers.get(POSTGRES_INSTANCE)
    postgres_container.stop()
    sys.exit(0)

signal.signal(signal.SIGINT, signal_handler)

client = docker.from_env()

logger.info(f"Running container {POSTGRES_INSTANCE}")
client.containers.run(
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
)
