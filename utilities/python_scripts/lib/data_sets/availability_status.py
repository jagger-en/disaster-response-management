from lib import constants
from lib import query


def add_to_database(name):
    payload = {
        "name": name,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    query.send_to_endpoint(constants.AVAILABILITY_STATUS_ADD, payload)
