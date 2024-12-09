import logging


def create_stdout_logger(logger_name):
    logger = logging.getLogger(logger_name)
    logger.setLevel(logging.INFO)

    console_handler = logging.StreamHandler()
    console_handler.setLevel(logging.INFO)

    formatter = logging.Formatter('%(asctime)s [ %(levelname)s ] -- %(name)s -- %(message)s')
    console_handler.setFormatter(formatter)

    logger.addHandler(console_handler)

    return logger
