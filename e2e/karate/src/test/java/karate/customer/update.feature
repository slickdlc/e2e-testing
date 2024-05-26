Feature: user Create API

  Background:
    Given def userPut = read('classpath:apis/karate/user/request/user-put.feature')

  Scenario: Negative Case - Identification duplicated
    * def req = read('testdata/update/negative-duplicate-identification-request.yml')
    * call userPut req

  Scenario: Negative Case - Invalid Id Request
    * def req = read('testdata/update/negative-invalid-id-request.yml')
    * call userPut req

  Scenario: Positive Case - El cliente ha sido actualizado satisfactoriamente
    * def req = read('testdata/update/positive-request.yml')
    * call userPut req
