import random
import helperFunc
the_endpoint = "teamEmployees/add"


teams_list = helperFunc.access_endpoint("teams/all")
employees_list = helperFunc.access_endpoint("employees/all")
def initialize(employee):
    team = random.sample(teams_list, 1)[0]
    
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
    result = helperFunc.send_to_endpoint(the_endpoint, payload)
    helperFunc.check_status(result.status_code, f"data: {employee}")


for jt in employees_list:
    initialize(jt)