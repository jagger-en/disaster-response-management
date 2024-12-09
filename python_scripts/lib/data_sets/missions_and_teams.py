import random
from lib import constants
from lib import query


def add_to_database(mission, team):
    year = random.randint(2020, 2021)
    month = random.randint(1, 12)
    day = random.randint(1, 20)

    start_time = f"{year}-{month}-{day}"
    end_time = ""
    payload = {
        "mission": mission,
        "team": team,
        "startTime": start_time,
        "endTime": end_time,
    }
    result = query.send_to_endpoint(constants.MISSIONS_AND_TEAMS_ADD, payload)
    query.check_status(result.status_code, f"data: {payload}")
