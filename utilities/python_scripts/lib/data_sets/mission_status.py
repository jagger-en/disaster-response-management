from lib import constants
from lib import query


def add_to_database(name, background):
    payload = {
        "name": name,
        "background": background,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    query.send_to_endpoint(constants.MISSION_STATUS_ADD, payload)
