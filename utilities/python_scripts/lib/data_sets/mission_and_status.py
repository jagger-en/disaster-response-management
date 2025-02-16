from lib import constants
from lib import query
import random


def add_to_database(mission, status):
    assignment_year = random.randint(2010, 2021)
    assignment_month = random.randint(1, 12)
    assignment_day = random.randint(1, 20)
    assignment_date = f"{assignment_year}-{assignment_month}-{assignment_day}T22:00:10"

    payload = {
        "mission": mission,
        "missionStatus": status,
        "assignmentDate": assignment_date
    }
    query.send_to_endpoint(constants.MISSION_AND_STATUS_ADD, payload)
