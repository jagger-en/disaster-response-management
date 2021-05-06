import random
import helperFunc
the_endpoint = "missionTeams/add"


teams_list = helperFunc.access_endpoint("teams/all")
missions_list = helperFunc.access_endpoint("missions/all")
def initialize():
    team = random.sample(teams_list, 1)[0]
    mission = random.sample(missions_list, 1)[0]
    
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
    result = helperFunc.send_to_endpoint(the_endpoint, payload)
    helperFunc.check_status(result.status_code, f"data: {mission}")


for _ in range(10):
    initialize()