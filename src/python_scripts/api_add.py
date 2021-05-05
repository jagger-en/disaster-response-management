import requests
import json
import time
import sys


points_add_endpoint = "http://localhost:8080/api/points/add"
vertices_add_endpoint = "http://localhost:8080/api/vertices/add"

points_all_endpoint = "http://localhost:8080/api/points/all"
pointType_all_endpoint = "http://localhost:8080/api/pointTypes/all"
locations_all_endpoint = "http://localhost:8080/api/locations/all"

def send_to_endpoint(endpoint, payload):
    headers = {'content-type': 'application/json', 'Host': 'myhost'}
    r = requests.post(endpoint, json=payload, headers=headers)
    return r

def access_endpoint(endpoint):
    r = requests.get(endpoint)
    r_dict_list = json.loads(r.text)
    return r_dict_list

def filter_by_name_query(name, endpoint):
    all_records = access_endpoint(endpoint)
    return [pt for pt in all_records if pt["name"] == name][0]

def check_status(status, msg):
    if status == 201:
        print(f"------SUCCESS------ {msg}")
    else:
        print(f"------ERROR------ {msg}")




json_file_path = sys.argv[1]
location_name = sys.argv[2]
point_type_name = sys.argv[3]
with open(json_file_path) as f:
  data_list = json.load(f)["features"]






for idx, geo_f in enumerate(data_list):
    point_name = f"Point-{idx}"
    longitude = geo_f["geometry"]["coordinates"][0]
    latitude = geo_f["geometry"]["coordinates"][1]
    height = 145
    point_payload = {
        "name": point_name,
        "longitude": longitude,
        "latitude": latitude,
        "height": height,
        "pointType": filter_by_name_query(point_type_name, pointType_all_endpoint)
    }
    result = send_to_endpoint(points_add_endpoint, point_payload)
    check_status(result.status_code, f"P: {point_name}")

    vertice_payload = {
        "point": filter_by_name_query(point_name, points_all_endpoint),
        "location": filter_by_name_query(location_name, locations_all_endpoint)
    }
    result = send_to_endpoint(vertices_add_endpoint, vertice_payload)
    check_status(result.status_code, f'V: {vertice_payload["point"]["name"]} {vertice_payload["location"]["name"]}')
    print()

