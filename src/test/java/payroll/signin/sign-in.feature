@mock-servlet-todo
Feature: csrf and sign-in end point

  Background:
    * url demoBaseUrl

    Given path 'login', 'token'
    When method get
    Then status 200
    And header X-CSRF-TOKEN = response

  Scenario: html url encoded form submit - post
    Given path 'login'
    And form field username = 'admin'
    And form field password = 'password'
    When method post
    Then status 200
    And match response == 'success'

  Scenario: html url encoded form submit - get
    Given path 'login'
    And form field username = 'admin'
    And form field password = 'password'
    When method get
    Then status 200
    And match response == 'success'

  Scenario: html url encoded form submit - manually forming the request / NOT using 'form field'
    Given path 'login'
    And request 'username=admin&password=password'
    And header Content-Type = 'application/x-www-form-urlencoded'
    When method post
    Then status 200
    And match response == 'success'
