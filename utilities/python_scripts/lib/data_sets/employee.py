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

    join_year = random.randint(2010, 2021)
    join_month = random.randint(1, 12)
    join_day = random.randint(1, 20)
    join_date = f"{join_year}-{join_month}-{join_day}"
    employee = {
        "firstName": first_name,
        "lastName": last_name,
        "dateOfBirth": date_of_birth,
        "phoneNumber": f'{random.randint(100, 200)}-{random.randint(100, 200)}-{random.randint(100, 200)}',
        "joinDate": join_date,
        "gender": query.filter_by_name_query(gender, constants.GENDER_ALL),
        "jobTitle": job_title,
    }
    result = query.send_to_endpoint(constants.EMPLOYEE_ADD, employee)
    query.check_status(result, f"employee: {employee}")
