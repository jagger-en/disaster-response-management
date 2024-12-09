#!/usr/bin/env python3
import random
from lib.logger import create_stdout_logger
from lib.data_sets import geo
from lib.data_sets import genders
from lib.data_sets import job_titles
from lib.data_sets import mission_types
from lib.data_sets import team_functionalities
from lib.data_sets import teams
from lib.data_sets import employees
from lib.data_sets import missions
from lib.data_sets import missions_and_teams
from lib.data_sets import teams_and_employees
from lib import constants
from lib import query

# The order matters!
if __name__ == "__main__":
    logger = create_stdout_logger(__name__)

    logger.info("populating database")

    # Populate geo data
    for location_name, point_type_name, json_file_path in [
        ("Construction locations", "icon_close", "./sample-data/icons/icon_close.json"),
        ("Forest fire", "icon_flame", "./sample-data/icons/icon_flame.json"),
        ("Southern front", "icon_firefighter", "./sample-data/icons/icon_firefighter.json"),
        ("Air support", "icon_helicopter", "./sample-data/icons/icon_helicopter.json"),
        ("Bridge water supply", "icon_storagetank", "./sample-data/icons/icon_storagetank.json"),
    ]:
        geo.add_to_database(location_name, point_type_name, json_file_path)
    locations_list = query.access_endpoint("locations/all")

    # Populate genders
    for gender_name in [
        "male",
        "female",
        "other",
    ]:
        genders.add_to_database(gender_name)

    # Populate job titles
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
        job_titles.add_to_database(job_title_name)
    job_titles_list = query.access_endpoint(constants.JOB_TITLES_ALL)

    # Populate teams
    for mission_type_name in [
        "Fire Suppression and Containment",
        "Logistics and Supply Distribution",
        "Evacuation and Shelter Management",
        "Medical and First Aid Response",
        "Fire Perimeter Control",
        "Damage Assessment",
        "Search and Rescue",
        "Communications and Coordination",
        "Community Outreach and Support",
        "Wildlife and Ecosystem Protection",
        "Hazardous Materials Management",
        "Air Support and Water Bombing Operations",
        "Disaster Relief Distribution",
        "Psychosocial Support and Counseling",
        "Environmental Recovery and Restoration"
    ]:
        mission_types.add_to_database(mission_type_name)
    mission_types_list = query.access_endpoint(constants.MISSION_TYPES_ALL)

    # Populate team functionalities
    for team_functionality_name in [
        "Fire Suppression and Containment",
        "Logistics and Supply Distribution",
        "Evacuation and Shelter Management",
        "Medical and First Aid Response",
        "Fire Perimeter Control",
        "Damage Assessment",
        "Search and Rescue",
        "Communications and Coordination",
        "Community Outreach and Support",
        "Wildlife and Ecosystem Protection",
        "Hazardous Materials Management",
        "Air Support and Water Bombing Operations",
        "Disaster Relief Distribution",
        "Psychosocial Support and Counseling",
        "Environmental Recovery and Restoration"
    ]:
        team_functionalities.add_to_database(team_functionality_name)
    team_functionalities = query.access_endpoint(constants.TEAM_FUNCTIONALITIES_ALL)

    # Populate teams
    for team_name in [
        "Thunderbolts",
        "Phoenix Force",
        "Stormbringers",
        "Steel Titans",
        "Shadow Warriors",
        "Crimson Hawks",
        "Galaxy Pioneers",
        "Iron Wolves",
        "Viper Squad",
        "Golden Eagles",
        "Raging Bulls",
        "Night Wolves",
        "Silver Sharks",
        "Alpha Pack",
        "Velocity Vanguards",
        "Inferno Legion",
        "Dark Knights",
        "Blaze Rangers",
        "Frozen Titans",
        "Rogue Falcons",
    ]:
        team_functionality = random.sample(team_functionalities, 1)[0]
        teams.add_to_database(team_name, team_functionality)
    teams_list = query.access_endpoint(constants.TEAMS_ALL)

    # Populate employees
    for _ in range(100):
        job_title = random.sample(job_titles_list, 1)[0]
        employees.add_to_database(job_title)
    employees_list = query.access_endpoint(constants.EMPLOYEES_ALL)

    # Populate missions
    # TODO: The data here is awkward because the types do not match the mission names.
    for mission_name in [
        "Operation Blaze Relief",
        "Mission Ashes Recovery",
        "Task Ember Evacuation",
        "Operation Firestorm Recovery",
        "Mission Fire Break Control",
        "Task Bushfire Relief Response",
        "Operation Red Cross Assistance",
        "Mission Outback Fire Recovery",
        "Task Wildfire Evacuation Plan",
        "Operation Firefighter Assistance",
        "Mission Black Summer Recovery",
        "Task Fire Damage Assessment",
        "Operation Air Support",
        "Mission Burnt Land Restoration",
        "Task Emergency Shelter Setup",
        "Operation Safe Haven Evacuation",
        "Mission Wildlife Protection",
        "Task Resource Allocation",
        "Operation Hazardous Material Clean-up",
        "Mission Post-Fire Infrastructure",
        "Task Recovery and Rehabilitation",
        "Operation Smoke and Air Quality Monitoring",
        "Mission Disaster Recovery",
        "Task Evacuee Health Monitoring",
        "Mission Community Resilience Building",
        "Task Fire Prevention Education",
        "Operation Fire Recovery Assistance",
        "Mission Fireproofing Communities",
        "Task Public Health and Safety",
        "Mission Southern Highlands Recovery",
        "Operation Outback Wildlife Recovery"
    ]:
        mission_type = random.sample(mission_types_list, 1)[0]
        location =random.sample(locations_list, 1)[0]
        missions.add_to_database(mission_name, mission_type, location)
    missions_list = query.access_endpoint(constants.MISSIONS_ALL)

    # Populate missions and teams relations
    for _ in range(20):
        mission = random.sample(missions_list, 1)[0]
        team = random.sample(teams_list, 1)[0]

        missions_and_teams.add_to_database(mission, team)

    # Populate teams and employees relations
    for employee in employees_list:
        team = random.sample(teams_list, 1)[0]

        teams_and_employees.add_to_database(team, employee)

    logger.info("done populating database")
