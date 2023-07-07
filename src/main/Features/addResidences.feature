@tag2
Feature: Adding Residences Sakancom Application.

  Scenario: Check if owner logged in and selected add residence option
    Given owner logged in
    And owner dashboard appears and selected add residence option
    Then adding list appears

  Scenario: owner wants to add picture or location and information or services or price or contact information to the residence
    Given owner is logged in
    And adding to the residence options appears and owner fills the description he chose
    Then residence added successfully