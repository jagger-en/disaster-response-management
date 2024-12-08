#!/bin/bash
python3.9 ./src/python_scripts/init0_api_geo_stuff.py ./src/python_scripts/icon_close.json --l "Construction locations" --i icon_close &&
python3.9 ./src/python_scripts/init0_api_geo_stuff.py ./src/python_scripts/icon_flame.json --l "Forest fire" --i icon_flame &&
python3.9 ./src/python_scripts/init0_api_geo_stuff.py ./src/python_scripts/icon_firefighter.json --l "Southern front" --i icon_firefighter &&
python3.9 ./src/python_scripts/init0_api_geo_stuff.py ./src/python_scripts/icon_helicopter.json --l "Air support" --i icon_helicopter &&
python3.9 ./src/python_scripts/init0_api_geo_stuff.py ./src/python_scripts/icon_storagetank.json --l "Bridge water supply" --i icon_storagetank

python3.9 ./src/python_scripts/init1_api_gender_add.py &&
python3.9 ./src/python_scripts/init2_api_jobtitle_add.py &&
python3.9 ./src/python_scripts/init3_api_missiontype_add.py &&
python3.9 ./src/python_scripts/init4_api_teamFunctionality_add.py &&
python3.9 ./src/python_scripts/init5_api_team_add.py &&
python3.9 ./src/python_scripts/init6_api_employees_add.py &&
python3.9 ./src/python_scripts/init7_api_mission_add.py &&
python3.9 ./src/python_scripts/init8_api_missionTeam_add.py &&
python3.9 ./src/python_scripts/init9_api_teamEmployee_add.py
