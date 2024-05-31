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

  Scenario: Negative Case - Gender field invalid
    Given url "http://localhost:8060"
    And path "/usuarios"
    And request '{"nombre": "Hans Burg De La Cruz Acosta","contrasena": "secretpassw0rd","direccion": "Av. 28 de Julio #1999","identificacion": "99990011","telefono": "900900900","activo": true,"genero": "J","edad": 26}'
    When method POST
    Then status 400
    And match response == '{"message":"El género debe ser 'F' o 'M'"}'

