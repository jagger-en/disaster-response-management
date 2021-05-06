import requests
import json
import time
import sys
import helperFunc

points_add_endpoint = "points/add"
vertices_add_endpoint = "vertices/add"
pointTypes_add_endpoint = "pointTypes/add"
locations_add_endpoint = "locations/add"

points_all_endpoint = "points/all"
pointType_all_endpoint = "pointTypes/all"
locations_all_endpoint = "locations/all"





def main():    
    pointType_payload = {
        "name": point_type_name,
        "description": "no description"
    }
    result = helperFunc.send_to_endpoint(pointTypes_add_endpoint, pointType_payload)
    helperFunc.check_status(result.status_code, f"PT: {point_type_name}")




    location_payload = {
        "name": location_name,
        "description": "no description"
    }
    result = helperFunc.send_to_endpoint(locations_add_endpoint, location_payload)
    helperFunc.check_status(result.status_code, f"PT: {location_name}")






    for idx, geo_f in enumerate(data_list):
        print()
        try:
            point_name = f"Point-{idx}"
            longitude = geo_f["geometry"]["coordinates"][0]
            latitude = geo_f["geometry"]["coordinates"][1]
            height = 145
            point_payload = {
                "name": point_name,
                "longitude": longitude,
                "latitude": latitude,
                "height": height,
                "pointType": helperFunc.filter_by_name_query(point_type_name, pointType_all_endpoint)
            }
            result = helperFunc.send_to_endpoint(points_add_endpoint, point_payload)
            helperFunc.check_status(result.status_code, f"P: {point_name}")
        except Exception as e:
            print(e)
        try:
            vertice_payload = {
                "point": helperFunc.filter_by_name_query(point_name, points_all_endpoint),
                "location": helperFunc.filter_by_name_query(location_name, locations_all_endpoint)
            }
            result = helperFunc.send_to_endpoint(vertices_add_endpoint, vertice_payload)
            helperFunc.check_status(result.status_code, f'V: {vertice_payload["point"]["name"]} {vertice_payload["location"]["name"]}')   
        except Exception as e:
            print(e)
















the_args = sys.argv
location_name = None
point_type_name = None
for idx, item in enumerate(the_args):
    if item == "--l":
        location_name = the_args[idx+1]
    if item == "--i":
        point_type_name = the_args[idx+1]


json_file_path = sys.argv[1]
with open(json_file_path) as f:
  data_list = json.load(f)["features"]


if point_type_name and location_name:
    print("\n*************************************")
    print("\n********** Initializing script\n")
    main()
else:
    print(f"Check your args: {the_args}")



"""
python api_add.py icon_close.json --l "Forest fire" --i icon_close
python api_add.py icon_firefighter.json --l "Hains Lane" --i icon_firefighter
python api_add.py icon_flame.json --l "Forest fire" --i icon_flame
python api_add.py icon_helicopter.json --l "Bridge water supply" --i icon_helicopter
python api_add.py icon_storagetank.json --l "Bridge water supply" --i icon_storagetank
"""