@tag1
  Feature: Login, change password or register as a owner or tenant.

    Scenario: admin can login
      Given admin wants to sign in
      And enters "123456" as a password
      And enters "admin" as a username
      Then admin login success
      And admin page appears

    Scenario: tenant can login
      Given tenant wants to sign in
      And enters the right username and password
      Then tenant login success
      And tenant page appears

    Scenario: owner can login
      Given owner wants to sign in
      And enters the correct username and password
      Then owner login success
      And owner page appears

    Scenario: admin,tenant or owner has the wrong password or username
      Given admin,tenant or owner wants to login to the system
      And the password or username is wrong
      Then error appears
      And stay in login page

    Scenario: admin,tenant or owner wants to change his password
      Given admin, tenant, owner wants to change his password
      And the password is the same old password
      Then error appears that tells that the password is the same old password
      And the password doesn't change and stay in change password page

    Scenario: successful registration as a tenant or owner
        Given user wants to register as a tenant or owner
        And fill in all or some of the information, and the username is available
        Then registration complete and the account is created
        And the tenant or owner can login to his new account

    Scenario: registration fail as a tenant or owner
      Given user wants to signup as a tenant or owner
      And fill in all or some of the information, and the username is username is unavailable
      Then registration fails and error appears
      And Account not created and stay in login page
