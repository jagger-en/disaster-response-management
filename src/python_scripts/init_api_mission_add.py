import random
import helperFunc
the_endpoint = "missions/add"


missionTypes_list = helperFunc.access_endpoint("missionTypes/all")
locations_list = helperFunc.access_endpoint("locations/all")
missions_list = ['Build hospital', 'Put out fire', 'Evacuate citizens', 'Transport food supplies']
def initialize():
    missionType = random.sample(missionTypes_list, 1)[0]
    location =random.sample(locations_list, 1)[0]
    mission = random.sample(missions_list, 1)[0]

    year = random.randint(2020, 2021)
    month = random.randint(1, 12)
    day = random.randint(1, 20)

    start_time = f"{year}-{month}-{day}"
    end_time = ""
    payload = {
        "name": mission,
        "description": "imagine there is some detailed description is here",
        "missionType": missionType,
        "location": location,
        "startTime": start_time,
        "endTime": end_time,
    }
    result = helperFunc.send_to_endpoint(the_endpoint, payload)
    helperFunc.check_status(result.status_code, f"data: {mission}")


for _ in range(50):
    initialize()