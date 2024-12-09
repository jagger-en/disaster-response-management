import names
import random
from lib import constants
from lib import query


def add_to_database(job_title):
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
        "gender": query.filter_by_name_query(gender, constants.GENDERS_ALL),
        "dateOfBirth": date_of_birth
    }
    result = query.send_to_endpoint(constants.PERSONS_ADD, person)
    query.check_status(result.status_code, f"person: {person}")

    join_year = random.randint(2010, 2021)
    join_month = random.randint(1, 12)
    join_day = random.randint(1, 20)
    join_date = f"{join_year}-{join_month}-{join_day}"
    employee = {
        "person": query.filter_by_firstname_query(first_name, constants.PERSONS_ALL),
        "jobTitle": job_title,
        "joinDate": join_date,
    }
    result = query.send_to_endpoint(constants.EMPLOYEES_ADD, employee)
    query.check_status(result.status_code, f"employee: {employee}")
