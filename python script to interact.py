import names
import random

def get_random_name():
    person_name = names.get_full_name(gender='male')
    if random.random() >= 0.5:
        person_name = names.get_full_name(gender='female')
    first_name = person_name.split(" ")[0]
    last_name = person_name.split(" ")[1]
    return {
        "first_name": first_name,
        "last_name": last_name
    }

person_name = get_random_name()
print(person_name)