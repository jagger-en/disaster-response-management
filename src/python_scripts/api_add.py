import requests
import json
import time
from geo_data import geo_data
from bridge_data import bridge_data
from road_data import road_data


pointType_endpoint = "http://localhost:8080/api/pointTypes/all"

def send_to_endpoint(endpoint, payload):
    headers = {'content-type': 'application/json', 'Host': 'myhost'}
    r = requests.post(endpoint, json=payload, headers=headers)
    return r

def access_endpoint(endpoint):
    r = requests.get(endpoint)
    r_dict_list = json.loads(r.text)
    return r_dict_list

def get_pointType_id(point_type_name):
    all_pointTypes = access_endpoint(pointType_endpoint)
    return [pt for pt in all_pointTypes if pt["name"] == point_type_name][0]



geo_features_list = [road_data["features"][0]]

for idx, geo_f in enumerate(geo_features_list):
    points_endpoint = "http://localhost:8080/api/points/add"
    name = f"Sample-{idx}"
    longitude = geo_f["geometry"]["coordinates"][0]
    latitude = geo_f["geometry"]["coordinates"][1]
    height = 145
    payload = {
        "name": name,
        "longitude": longitude,
        "latitude": latitude,
        "height": height,
        "pointType": 7
    }
    send_to_endpoint(points_endpoint, payload)
    print(f"Wait...data-{idx} was inserted.")

