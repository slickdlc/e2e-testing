Feature: user Create API

  Background:
    Given def userGet = read('classpath:apis/karate/user/request/user-get.feature')

  Scenario: Positive Case - users retrieved successfully
    * def req = read('testdata/getall/positive-request.yml')
    * def response = call userGet req
    * match response.body != "#[1]"
