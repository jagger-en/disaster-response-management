import random
from lib import constants
from lib import query

def add_to_database(team, employee):
    year = random.randint(1980, 2000)
    month = random.randint(1, 12)
    day = random.randint(1, 20)

    start_time = f"{year}-{month}-{day}"
    end_time = ""
    payload = {
        "employee": employee,
        "team": team,
        "startTime": start_time,
        "endTime": end_time,
    }
    result = query.send_to_endpoint(constants.TEAMS_AND_EMPLOYEES_ADD, payload)
    query.check_status(result.status_code, f"data: {payload}")
