import random
import helperFunc
the_endpoint = "teams/add"


the_list = ['Alpha838', 'CakeMonstas', 'TaxiTanks', 'SurveyDadada', 'RockNRoll12354']
teamFunctionalitys_list = helperFunc.access_endpoint("teamFunctionalities/all")
def initialize(name):
    teamFunctionality = random.sample(teamFunctionalitys_list, 1)[0]
    payload = {
        "name": name,
        "teamFunctionality": teamFunctionality
    }
    result = helperFunc.send_to_endpoint(the_endpoint, payload)
    helperFunc.check_status(result.status_code, f"data: {name}")


for jt in the_list:
    initialize(jt)