#!/bin/bash
curl --silent http://127.0.0.1:8081/api/availability-status/all | jq . > ./resources/test-data/availability-status.json
curl --silent http://127.0.0.1:8081/api/employee/all | jq . > ./resources/test-data/employee.json
curl --silent http://127.0.0.1:8081/api/gender/all | jq . > ./resources/test-data/gender.json
curl --silent http://127.0.0.1:8081/api/job-title/all | jq . > ./resources/test-data/job-title.json
curl --silent http://127.0.0.1:8081/api/location/all | jq . > ./resources/test-data/location.json
curl --silent http://127.0.0.1:8081/api/mission-and-location/all | jq . > ./resources/test-data/mission-and-location.json
curl --silent http://127.0.0.1:8081/api/mission-and-status/all | jq . > ./resources/test-data/mission-and-status.json
curl --silent http://127.0.0.1:8081/api/mission/all | jq . > ./resources/test-data/mission.json
curl --silent http://127.0.0.1:8081/api/mission-assignment/all | jq . > ./resources/test-data/mission-assignment.json
curl --silent http://127.0.0.1:8081/api/mission-location-items/all | jq . > ./resources/test-data/mission-location-items.json
curl --silent http://127.0.0.1:8081/api/mission-status/all | jq . > ./resources/test-data/mission-status.json
curl --silent http://127.0.0.1:8081/api/mission-summaries/all | jq . > ./resources/test-data/mission-summaries.json
curl --silent http://127.0.0.1:8081/api/mission-timeline-items/all | jq . > ./resources/test-data/mission-timeline-items.json
