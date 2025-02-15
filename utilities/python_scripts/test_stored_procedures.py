#!/usr/bin/env python3
import unittest
import requests
import json

def read_test_file(file_path):
    with open(file_path, 'r') as f:
        return json.loads(f.read())

# get_all_mission_summaries
class TestStoredProcedures(unittest.TestCase):
    def test_get_all_mission_summaries(self):
        url = "http://127.0.0.1:8081/api/mission-summaries/all"
        result = requests.get(url)

        expected = read_test_file("./resources/test-data/mission-summaries.json")

        self.assertEqual(expected, result.json())

    def test_get_all_mission_timeline_item(self):
        url = "http://127.0.0.1:8081/api/mission-timeline-items/all"
        result = requests.get(url)

        expected = read_test_file("./resources/test-data/mission-timeline-items.json")

        self.assertEqual(expected, result.json())

    def test_get_all_mission_location_item(self):
        url = "http://127.0.0.1:8081/api/mission-location-items/all"
        result = requests.get(url)

        expected = read_test_file("./resources/test-data/mission-location-items.json")

        self.assertEqual(expected, result.json())

if __name__ == "__main__":
    unittest.main()
