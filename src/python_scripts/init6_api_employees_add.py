import names
import random
import requests
import json
import time
import sys
import helperFunc


jobtitles_list = helperFunc.access_endpoint("jobTitles/all")
def add_stuff():
    person_name = names.get_full_name(gender='male')
    gender = "male"
    if random.random() >= 0.5:
        person_name = names.get_full_name(gender='female')
        gender = "female"
    first_name = person_name.split(" ")[0]
    last_name = person_name.split(" ")[1]


    year = random.randint(1980, 2000)
    month = random.randint(1, 12)
    day = random.randint(1, 20)

    date_of_birth = f"{year}-{month}-{day}"
    person = {
        "firstName": first_name,
        "lastName": last_name,
        "gender": helperFunc.filter_by_name_query(gender, "genders/all"),
        "dateOfBirth": date_of_birth
    }
    result = helperFunc.send_to_endpoint("persons/add", person)
    helperFunc.check_status(result.status_code, f"person: {person}")

    jobTitle = random.sample(jobtitles_list, 1)[0]

    join_year = random.randint(2010, 2021)
    join_month = random.randint(1, 12)
    join_day = random.randint(1, 20)
    join_date = f"{join_year}-{join_month}-{join_day}"
    employee = {
        "person": helperFunc.filter_by_firstname_query(first_name, "persons/all"),
        "jobTitle": jobTitle,
        "joinDate": join_date,
    }
    result = helperFunc.send_to_endpoint("employees/add", employee)
    helperFunc.check_status(result.status_code, f"employee: {employee}")


for _ in range(2):
    add_stuff()
