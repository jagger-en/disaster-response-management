import helperFunc
genders_add_endpoint = "genders/add"
def initialize_genders():
    gender_name = "female"
    gender_payload = {
        "name": gender_name,
        "description": "no description"
    }
    result = helperFunc.send_to_endpoint(genders_add_endpoint, gender_payload)
    helperFunc.check_status(result.status_code, f"Gender: {gender_name}")

    gender_name = "male"
    gender_payload = {
        "name": gender_name,
        "description": "no description"
    }
    result = helperFunc.send_to_endpoint(genders_add_endpoint, gender_payload)
    helperFunc.check_status(result.status_code, f"Gender: {gender_name}")
initialize_genders()