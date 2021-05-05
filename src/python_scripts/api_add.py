import requests
import json
from geo_data import geo_data_collection

def send_to_endpoint(endpoint, payload):
    headers = {'content-type': 'application/json', 'Host': 'myhost'}
    r = requests.post(endpoint, json=payload, headers=headers)
    return r


geo_features_list = geo_data_collection["features"]

for geo_f in geo_features_list:
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

