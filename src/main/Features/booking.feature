Feature:ability to booking
Scenario: theres available housing to booking
  Given tenant wants to booking and theres available housing id "1"
  And the tenant typed "Yes" then type the id "1"
  Then the booking of housing with id "1" will done and the tenant username is "YazanM23"

  Scenario: theres available housing to booking
    Given tenant doesn't want to booking
    And the tenant typed "No"
    Then the booking will not done


