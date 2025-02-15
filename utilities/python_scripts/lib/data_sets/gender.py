from lib import constants
from lib import query


def add_to_database(name):
    payload = {
        "name": name,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    result = query.send_to_endpoint(constants.GENDER_ADD, payload)
    query.check_status(result, f"{__name__}: {name}")
