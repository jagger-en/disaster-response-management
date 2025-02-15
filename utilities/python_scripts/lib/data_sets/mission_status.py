from lib import constants
from lib import query


def add_to_database(name, background):
    payload = {
        "name": name,
        "background": background,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    result = query.send_to_endpoint(constants.MISSION_STATUS_ADD, payload)
    query.check_status(result, f"{__name__}: {name}")
