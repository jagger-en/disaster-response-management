import json
from lib import constants
from lib import query


def add_to_database(location_name, point_type_name, json_file_path):
    data_list = _load_geo_data(json_file_path)

    return _add_to_database(location_name, point_type_name, data_list)

def _load_geo_data(json_file_path):
    with open(json_file_path) as f:
      return json.load(f)["features"]

def _add_to_database(location_name, point_type_name, data_list):
    pointType_payload = {
        "name": point_type_name,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    result = query.send_to_endpoint(constants.POINT_TYPES_ADD, pointType_payload)
    query.check_status(result.status_code, f"PT: {point_type_name}")

    location_payload = {
        "name": location_name,
        "description": constants.BOILER_PLATE_DESCRIPTION
    }
    result = query.send_to_endpoint(constants.LOCATIONS_ADD, location_payload)
    query.check_status(result.status_code, f"PT: {location_name}")

    for idx, geo_f in enumerate(data_list):
        try:
            point_name = f"Point-{point_type_name}-{idx}"
            longitude = geo_f["geometry"]["coordinates"][0]
            latitude = geo_f["geometry"]["coordinates"][1]
            height = 145
            point_payload = {
                "name": point_name,
                "longitude": longitude,
                "latitude": latitude,
                "height": height,
                "pointType": query.filter_by_name_query(point_type_name, constants.POINT_TYPES_ALL)
            }
            result = query.send_to_endpoint(constants.POINTS_ADD, point_payload)
            query.check_status(result.status_code, f"P: {point_name}")
        except Exception as e:
            print(e)
        try:
            vertice_payload = {
                "point": query.filter_by_name_query(point_name, constants.POINTS_ALL),
                "location": query.filter_by_name_query(location_name, constants.LOCATIONS_ALL)
            }
            result = query.send_to_endpoint(constants.VERTICES_ADD, vertice_payload)
            query.check_status(result.status_code, f'V: {vertice_payload["point"]["name"]} {vertice_payload["location"]["name"]}')
        except Exception as e:
            print(e)
