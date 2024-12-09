from lib import constants
from lib import query


def add_to_database(gender_name):
    gender_payload = {
        "name": gender_name,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    result = query.send_to_endpoint(constants.GENDERS_ADD, gender_payload)
    query.check_status(result.status_code, f"Gender: {gender_name}")
