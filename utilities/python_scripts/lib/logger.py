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

def create_file_logger(logger_name, log_file_path):
    logger = logging.getLogger(logger_name)
    logger.setLevel(logging.INFO)

    fileHandler = logging.FileHandler(filename=log_file_path)
    fileHandler.setLevel(logging.INFO)
    formatter = logging.Formatter(fmt="%(asctime)s [%(levelname)s] %(message)s")
    fileHandler.setFormatter(formatter)
   
    logger.addHandler(fileHandler)

    return logger
