import random
from lib import constants
from lib import query


def add_to_database(mission, employee):
    year = random.randint(2020, 2021)
    month = random.randint(1, 12)
    day = random.randint(1, 20)

    start_time = f"{year}-{month}-{day}"
    payload = {
        "mission": mission,
        "employee": employee,
        "assignmentTime": start_time,
    }
    result = query.send_to_endpoint(constants.MISSION_ASSIGNMENT_ADD, payload)
    query.check_status(result, f"data: {payload}")
