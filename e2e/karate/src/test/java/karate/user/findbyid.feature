Feature: user Create API

  Background:
    Given def userGet = read('classpath:apis/karate/user/request/user-get.feature')

  Scenario: Negative Case - Invalid Id
    * def req = read('testdata/findbyid/negative-request.yml')
    * call userGet req

  Scenario: Positive Case - user retrieved successfully
    * def req = read('testdata/findbyid/positive-request.yml')
    * call userGet req
