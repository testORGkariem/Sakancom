@tag1
Feature: Scenes of requests for advertisement of housing and the ability to accept and reject it

  Scenario: admin accepts housings
    Given admin logged in with "admin" as username and "123456" as password and dashboard appears
    And  selected "1" from dashboard and see the pending features
    And selected one of the pending housings
    And Selected "yes" to accept the housing or "no" to rejects it
    Then housing accepted or rejected

