Feature: user Create API

  Background:
    Given def userPost = read('classpath:apis/karate/user/request/user-post.feature')

  Scenario: Negative Case - Bad Identification
    * def req = read('testdata/create/negative-request-bad-identification.yml')
    * call userPost req

  Scenario: Negative Case - Bad Parameters
    * def req = read('testdata/create/negative-request-bad-parameters.yml')
    * call userPost req

  Scenario: Positive Case - user created
    * def req = read('testdata/create/positive-request.yml')
    * call userPost req
