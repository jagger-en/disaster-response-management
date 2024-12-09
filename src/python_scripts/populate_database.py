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
        "driver",
        "paramedic",
        "nurse",
        "cook",
        "geo-surveyor",
        "pilot",
        "construction-worker",
    ]:
        job_titles.add_to_database(job_title_name)
    job_titles_list = query.access_endpoint(constants.JOB_TITLES_ALL)

    # Populate teams
    for mission_type_name in [
        "rescue",
        "construction",
        "first-response",
        "survey",
    ]:
        mission_types.add_to_database(mission_type_name)
    mission_types_list = query.access_endpoint(constants.MISSION_TYPES_ALL)

    # Populate team functionalities
    for team_functionality_name in [
        "medical",
        "construction",
        "transportation",
        "survey",
    ]:
        team_functionalities.add_to_database(team_functionality_name)
    team_functionalities = query.access_endpoint(constants.TEAM_FUNCTIONALITIES_ALL)

    # Populate teams
    for team_name in [
        "Alpha838",
        "CakeMonstas",
        "TaxiTanks",
        "SurveyDadada",
        "RockNRoll12354",
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
    mission_names_list = ['Build hospital', 'Put out fire', 'Evacuate citizens', 'Transport food supplies']
    for mission_name in mission_names_list:
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
