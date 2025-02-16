from lib import constants
from lib import query


def add_to_database(mission, location):
    payload = {
        "mission": mission,
        "location": location,
    }
    query.send_to_endpoint(constants.MISSION_AND_LOCATION_ADD, payload)
