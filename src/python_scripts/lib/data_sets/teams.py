import random
from lib import constants
from lib import query


def add_to_database(name, team_functionality):
    payload = {
        "name": name,
        "teamFunctionality": team_functionality
    }

    result = query.send_to_endpoint(constants.TEAMS_ADD, payload)
    query.check_status(result.status_code, f"data: {name}")
