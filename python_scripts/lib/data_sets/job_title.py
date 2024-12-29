from lib import query
from lib import constants


def add_to_database(name):
    payload = {
        "name": name,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    result = query.send_to_endpoint(constants.JOB_TITLE_ADD, payload)
    query.check_status(result.status_code, f"{__name__}: {name}")
