Posting a new survivor
Http method : post
url: http://localhost:8082/survivors
dummy json format
{
"name": "Gift Manaka",
"age": 29,
"gender": "MALE",
"latitude": 607.7749,
"longitude": 100.4194
}

Getting a new survivor
Http method : get
url: http://localhost:8082/survivors
===============
updating latitude and longitude
Http method : put/patch
url: http://localhost:8082/survivors/1
Dummy json format
{
"latitude": 40.7128,
"longitude": -74.0060
}
=================
posting inventories
Http method: post
url: http://localhost:8082/inventories
{
"survivorId": 1,
"hasWater": true,
"hasFood": false,
"hasMedication": true,
"hasAmmunition": true
}
Reporting survivor's status
Http method : put
url: http://localhost:8082/survivors/1/report-infection
====================
Getting list of robots
Http method: get
url: http://localhost:8082/sorted-robots
=====================
get list of infected survivors
Http method: get
url: http://localhost:8082/survivors/infected
==================
infected survivors %
http method: get
url: http://localhost:8082/survivors/infected-percentage
=================
disinfected survivors %
http method: get
url:http://localhost:8082/survivors/disinfected-percentage