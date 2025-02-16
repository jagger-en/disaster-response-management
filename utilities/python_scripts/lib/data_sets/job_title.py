from lib import query
from lib import constants


def add_to_database(name):
    payload = {
        "name": name,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    query.send_to_endpoint(constants.JOB_TITLE_ADD, payload)
