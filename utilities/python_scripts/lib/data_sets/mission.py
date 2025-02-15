import random
from lib import constants
from lib import query


def add_to_database(name, mission_status):

    year = random.randint(2023, 2024)
    month = random.randint(1, 12)
    day = random.randint(1, 20)

    start_time = f"{year}-{month}-{day}"
    end_time = ""
    payload = {
        "name": name,
        "description": constants.BOILER_PLATE_DESCRIPTION,
        "missionStatus": mission_status,
        "statusTtl": random.randint(30, 60 * 60 * 24),
        "startTime": start_time,
        "endTime": end_time,
    }
    result = query.send_to_endpoint(constants.MISSION_ADD, payload)
    query.check_status(result, f"data: {payload}")
