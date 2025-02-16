from lib import query
from lib import constants

def add_to_database(name, latitude, longitude):
    payload = {
        "name": name,
        "description": "no description",
        "latitude": latitude,
        "longitude": longitude,
    }
    query.send_to_endpoint(constants.LOCATION_ADD, payload)
