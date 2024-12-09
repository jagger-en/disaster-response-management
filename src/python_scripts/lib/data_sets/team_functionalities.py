from lib import constants
from lib import query


def add_to_database(team_functionality_name):
    payload = {
        "name": team_functionality_name,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    result = query.send_to_endpoint(constants.TEAM_FUNCTIONALITIES_ADD, payload)
    query.check_status(result.status_code, f"data: {team_functionality_name}")
