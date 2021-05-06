import helperFunc
jobtitles_add_endpoint = "jobTitles/add"


jobTitles_list = ['driver', 'paramedic', 'nurse', 'cook', 'geo-surveyor', 'pilot', 'construction-worker']

def initialize_jobTitles(name):
    payload = {
        "name": name,
        "description": "no description"
    }
    result = helperFunc.send_to_endpoint(jobtitles_add_endpoint, payload)
    helperFunc.check_status(result.status_code, f"Jobtitle: {name}")


for jt in jobTitles_list:
    initialize_jobTitles(jt)