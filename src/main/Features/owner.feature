@tag2
Feature: Adding Residences Sakancom Application.

  Scenario: Check if owner logged in and selected add residence option
    Given owner wants to login and add a residence
    And owner enters "Ahmad mohammed" as username and "11223344" as a password
    Then owner logged in with "Ahmad mohammed" as username and "11223344" as a password and dashboard appears and adding list appears

  Scenario: owner wants to add picture or location and information or services or price or contact information to the residence
    Given owner is logged in with username "Ahmad mohammed" and  password "11223344" and dashboard appears then selected "1" for housing then selected "1" for add housing
    And adding to the housing options appears and owner enters "Ahmad mohammed" as username of owner  and "huge building, nice view, the area is 3x3 square meters and has a balcony, its studio for one student with one bathroom, there are a shared washing machine, each floor has 4 studios and the building is 4 floors , 1km away from university campus" as a residence description and "shared washing machine, balcony, owner pays water, electricity and internet" as a services and "1 bathroom in each studio" as number of bathrooms and "yes" as it have a balcony and "1500 ILS including water, electricity and internet" as a price and and 7 as floors "Academic Residence" as residence name
    Then residence added successfully

    Scenario: show housings
      Given owner logged in
      And dashboard appears then selected "1" for housing then selected "2" for show housings
      Then housings appears

