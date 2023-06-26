@tag1
  Feature: Login, change password or register as a owner or tenant.

    Scenario: admin can login
      Given admin wants to sign in
      And enters the right username and password
      Then admin login success
      And admin page appears

    Scenario: admin has the wrong password
      Given admin wants to login to his account
      And the password is wrong
      Then error appears that tells that the password is wrong
      And stay in the login page

    Scenario: admin has the wrong username
      Given admin wants to login to his account
      And the username is wrong
      Then error appears that tells that the username is wrong
      And stay in the login page

    Scenario: tenant can login
      Given tenant wants to sign in
      And enters the right username and password
      Then tenant login success
      And tenant page appears

    Scenario: tenant has the wrong password
    Given tenant wants to login to his account
    And the password is wrong
    Then error appears that tells that the password is wrong
    And stay in the login page

    Scenario: tenant has the wrong username
      Given tenant wants to login to his account
      And the username is wrong
      Then error appears that tells that the username is wrong
      And stay in the login page

    Scenario: owner can login
      Given tenant wants to sign in
      And enters the right username and password
      Then owner login success
      And owner page appears

    Scenario: owner has the wrong password
      Given owner wants to login to his account
      And the password is wrong
      Then error appears that tells that the password is wrong
      And stay in the login page

    Scenario: owner has the wrong username
      Given owner wants to login to his account
      And the username is wrong
      Then error appears that tells that the username is wrong
      And stay in the login page

    Scenario: user or admin wants to change his password
      Given user wants to change his password
      And the password is the same old password
      Then error appears that tells that the password is the same old password
      And the password doesn't change and stay in change password page

    Scenario: successful registration as a tenant
        Given user wants to register as a tenant
        And fill in all or some of the information, and the username is available
        Then registration complete and the account is created
        And the tenant can login to his new account

    Scenario: registration fail as a tenant
      Given user wants to register as a tenant
      And fill in all or some of the information, and the username is username is unavailable
      Then registration fails and error appears
      And the tenant can login to his new account

    Scenario: successful registration as a owner
      Given user wants to register as a owner
      And fill in all or some of the information, and the username is available
      Then registration complete and the account is created
      And the owner can login to his new account

    Scenario: registration fail as a owner
      Given user wants to register as a owner
      And fill in all or some of the information, and the username is username is unavailable
      Then registration fails and error appears
      And the owner can login to his new account