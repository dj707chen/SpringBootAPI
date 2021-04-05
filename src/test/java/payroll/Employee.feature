Feature: Employee creation, search, update and deletion

  Background:
    * url demoBaseUrl
    * configure logPrettyRequest = true
    * configure logPrettyResponse = true
    * header Authorization = call read('basic-auth.js') { username: 'admin', password: 'password' }

  Scenario: create and retrieve an employee record

## login
#    Given path 'login'
#    And form field username = 'admin'
#    And form field password = 'password'
#    When method get
#    Then status 200
#    And match response == 'success'

# create a new employee record
    Given path 'employees'
    And request { name: 'John Smith', role: 'Scrum Master' }
    When method post
    Then status 200
    And match response == { id: '#number', name: 'John Smith', role: 'Scrum Master' }

    * def id = response.id

# get by id
    Given path 'employees', id
    When method get
    Then status 200
    And match response == { id: '#(id)', name: 'John Smith', role: 'Scrum Master' }

# get all employees
    Given path 'employees'
    When method get
    Then status 200
    And match response contains { id: '#(id)', name: 'John Smith', role: 'Scrum Master' }

## get cat but ask for xml
#    Given path 'employees', id
#    And header Accept = 'application/xml'
#    When method get
#    Then status 200
#    And match response == <employee><id>#(id)</id><name>John Smith</name><role>Scrum Master</role></employee>
