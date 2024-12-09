from lib import query
from lib import constants

def add_to_database(job_title_name):
    payload = {
        "name": job_title_name,
        "description": "no description"
    }
    result = query.send_to_endpoint(constants.JOB_TITLES_ADD, payload)
    query.check_status(result.status_code, f"Jobtitle: {job_title_name}")
