Feature: user Create API

  Background:
    Given def userDelete = read('classpath:apis/karate/user/request/user-delete.feature')

  Scenario: Negative Case - Invalid Id
    * def req = read('testdata/delete/negative-invalid-id-request.yml')
    * call userDelete req

  Scenario: Positive Case - user deleted
    * def req = read('testdata/delete/positive-request.yml')
    * call userDelete req
