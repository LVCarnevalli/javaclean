@CleanStubby
Feature: Default
  This is feature test API pokemon

  Background:
    Given A have a mock pokeapi-detail for dependency pokeapi
    And the feature detail-pokemon is ENABLE

  Scenario: Detail pokemon with success
    When I make a GET to api/v1/pokemon/132/ditto
    Then I expect to receive a 200 status with body response.json

  Scenario: Search for pokemon that doens't exist
    When I make a GET to api/v1/pokemon/133/Pikachu
    Then I expect to receive a 404 status with body responseNotFound.json

  Scenario: Occurred internal error in application
    When I make a GET to api/v1/pokemon/psyduck/psyduck
    Then I expect to receive a 500 status with body responseInternalServerError.json

  Scenario: Detail pokemon without feature toggle
    Given the feature detail-pokemon is DISABLE
    When I make a GET to api/v1/pokemon/132/ditto
    Then I expect to receive a 404 status with body responseNotFound.json