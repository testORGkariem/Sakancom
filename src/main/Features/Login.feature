@tag1
  Feature: Login or register as a owner or tenant.

    Scenario: admin can login
      Given admin wants to sign in
      And enters "admin" as a username and enters "123456" as a password
      Then admin login success

    Scenario: successful login
      Given tenant or owner wants to login to the system
      And enters "kariem" as a username and "123456" as a password and both are correct
      Then login successful

    Scenario: failure login
      Given tenant or owner login to the system
      And enters "kariemm" as a username and "1234566" as a password and one of them are wrong
      Then error appears

    Scenario: successful registration as a tenant or owner
        Given user wants to register as a tenant or owner
        And fill in all or some of the information, and the username is available
        Then registration complete and the account is created

    Scenario: registration fail as a tenant or owner
      Given user wants to signup as a tenant or owner
      And fill in all or some of the information, and the username is username is unavailable
      Then registration fails and error appears

      Scenario: admin, tenant or owner want to logout
        Given admin, tenant or owner already logged in to the system
        And pressed logout
        Then admin, tenant or owner logged out successfully