import requests
import json
import time
import sys


def send_to_endpoint(endpoint, payload):
    endpoint = f"http://localhost:8081/api/{endpoint}"
    headers = {'content-type': 'application/json', 'Host': 'myhost'}
    r = requests.post(endpoint, json=payload, headers=headers)
    return r

def access_endpoint(endpoint):
    endpoint = f"http://localhost:8081/api/{endpoint}"
    r = requests.get(endpoint)
    r_dict_list = json.loads(r.text)
    return r_dict_list

def filter_by_name_query(name, endpoint):
    result = None
    try:
        all_records = access_endpoint(endpoint)
        result = [record for record in all_records if record["name"] == name][0]
    except Exception as e:
        print(e)
    return result

def filter_by_firstname_query(name, endpoint):
    result = None
    try:
        all_records = access_endpoint(endpoint)
        result = [record for record in all_records if record["firstName"] == name][0]
    except Exception as e:
        print(e)
    return result

def check_status(status, msg):
    if status == 201:
        print(f"------SUCCESS------ {msg}")
    else:
        print(f"------ERROR------ {msg}")
