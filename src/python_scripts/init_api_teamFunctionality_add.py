import helperFunc
the_endpoint = "teamFunctionalities/add"


the_list = ['medical', 'construction', 'transportation', 'survey']

def initialize(name):
    payload = {
        "name": name,
        "description": "no description"
    }
    result = helperFunc.send_to_endpoint(the_endpoint, payload)
    helperFunc.check_status(result.status_code, f"data: {name}")


for jt in the_list:
    initialize(jt)