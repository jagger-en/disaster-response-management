import requests
import json
import time
from geo_data import geo_data
from bridge_data import bridge_data
from road_data import road_data

def send_to_endpoint(endpoint, payload):
    headers = {'content-type': 'application/json', 'Host': 'myhost'}
    r = requests.post(endpoint, json=payload, headers=headers)
    return r


geo_features_list = road_data["features"]

for idx, geo_f in enumerate(geo_features_list):
    points_endpoint = "http://localhost:8080/api/points/add"
    name = "Sample1"
    longitude = geo_f["geometry"]["coordinates"][0]
    latitude = geo_f["geometry"]["coordinates"][1]
    height = 145
    payload = {
        "name": name,
        "longitude": longitude,
        "latitude": latitude,
        "height": height
    }
    send_to_endpoint(points_endpoint, payload)
    print(f"Wait...data-{idx} was inserted.")

