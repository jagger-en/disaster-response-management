#!/usr/bin/env python3
import random
from lib.logger import create_stdout_logger
from lib.data_sets import availability_status
from lib.data_sets import employee as emp
from lib.data_sets import gender
from lib.data_sets import job_title as jt
from lib.data_sets import location as loc
from lib.data_sets import mission_and_location
from lib.data_sets import mission_and_status
from lib.data_sets import mission_assignment
from lib.data_sets import mission_status
from lib.data_sets import mission as mis
from lib import constants
from lib import query

# The order matters!
def populate_database():
    logger = create_stdout_logger(__name__)

    logger.info("populating database")

    # Populate availability_status table
    for status_name in [
        "AVAILABLE",
        "UNKNOWN",
        "UNAVAILABLE",
    ]:
        availability_status.add_to_database(status_name)

    # Populate mission_status table
    for status_name, status_background in [
        ("PENDING", "warning.main"),
        ("COMPLETED", "success.main"),
        ("CANCELLED", "error.main"),
    ]:
        mission_status.add_to_database(status_name, status_background)
    mission_status_list = query.access_endpoint(constants.MISSION_STATUS_ALL)

    # Populate mission table
    for mission_name, status_name in zip([
        "Recover supplies",
        "Deliver supplies",
        "Build tents",
    ], mission_status_list):
        mis.add_to_database(mission_name, status_name)
    mission_list = query.access_endpoint(constants.MISSION_ALL)

    # Populate gender table
    for gender_name in [
        "male",
        "female",
        "other",
    ]:
        gender.add_to_database(gender_name)

    # Populate job title table
    for job_title_name in [
        "Wildfire Response Coordinator",
        "Firefighter/Rescue Specialist",
        "Wildfire Incident Commander",
        "Logistics and Supply Chain Manager",
        "Emergency Medical Technician (EMT)",
        "Community Liaison Officer",
        "Fire Behaviour Analyst",
        "Incident Communications Officer",
        "Crisis Management Consultant",
        "Fire Safety Officer",
        "Wildfire Evacuation Specialist",
        "Search and Rescue Specialist",
        "Water and Air Operations Manager",
        "Disaster Relief Coordinator",
        "Environmental Restoration Specialist",
        "Infrastructure Recovery Specialist",
        "Wildlife and Ecosystem Officer",
        "Evacuation Shelter Manager",
        "Disaster Recovery Specialist",
        "Public Health Specialist",
        "Field Operations Supervisor",
        "Wildfire Recovery Officer",
        "Disaster Analyst",
        "Community Outreach Coordinator",
        "Fire Perimeter Control Specialist",
        "Transportation and Evacuation Coordinator",
        "Flood and Erosion Control Specialist",
        "Hazardous Materials Handler",
        "Psychosocial Support Officer",
        "Volunteer Coordinator"
    ]:
        jt.add_to_database(job_title_name)
    job_title_list = query.access_endpoint(constants.JOB_TITLE_ALL)

    # Populate employee table
    for _ in range(100):
        job_title = random.sample(job_title_list, 1)[0]
        emp.add_to_database(job_title)
    employee_list = query.access_endpoint(constants.EMPLOYEE_ALL)

    # Populate location table
    for name, latitude, longitude in [
        ("Round Mountain Peak", "-120.6169", "38.5385"),
        ("River Base 77", "-120.6130", "38.5359"),
        ("Drop zone 45", "-120.6222", "38.5351"),
    ]:
        loc.add_to_database(name, latitude, longitude)
    location_list = query.access_endpoint(constants.LOCATION_ALL)

    # Populate mission and location table
    for location, mission in zip(location_list, mission_list):
        mission_and_location.add_to_database(mission, location)

    # Populate mission and status table
    for status, mission in zip(mission_status_list, mission_list):
        mission_and_status.add_to_database(mission, status)

    # Populate mission assignment
    for mission in mission_list:
        employees = random.sample(employee_list, random.randint(1, 20))
        for employee in employees:
            mission_assignment.add_to_database(mission, employee)

    logger.info("done populating database")

# The order matters!
def populate_database_with_test_data():
    logger = create_stdout_logger(__name__)

    logger.info("populating database for testing")

    # Populate availability_status table
    query.send_to_endpoint_from_file(constants.AVAILABILITY_STATUS_ADD, './resources/test-data/availability-status.json')

    # Populate mission_status table
    query.send_to_endpoint_from_file(constants.MISSION_STATUS_ADD, './resources/test-data/mission-status.json')

    # Populate mission table
    query.send_to_endpoint_from_file(constants.MISSION_ADD, './resources/test-data/mission.json')

    # Populate gender table
    query.send_to_endpoint_from_file(constants.GENDER_ADD, './resources/test-data/gender.json')

    # Populate job title table
    query.send_to_endpoint_from_file(constants.JOB_TITLE_ADD, './resources/test-data/job-title.json')

    # Populate employee table
    query.send_to_endpoint_from_file(constants.EMPLOYEE_ADD, './resources/test-data/employee.json')

    # Populate location table
    query.send_to_endpoint_from_file(constants.LOCATION_ADD, './resources/test-data/location.json')

    # Populate mission and location table
    query.send_to_endpoint_from_file(constants.MISSION_AND_LOCATION_ADD, './resources/test-data/mission-and-location.json')

    # Populate mission and status table
    query.send_to_endpoint_from_file(constants.MISSION_AND_STATUS_ADD, './resources/test-data/mission-and-status.json')

    # Populate mission assignment
    query.send_to_endpoint_from_file(constants.MISSION_ASSIGNMENT_ADD, './resources/test-data/mission-assignment.json')

    logger.info("done populating database for testing")

if __name__ == "__main__":
    populate_database()
