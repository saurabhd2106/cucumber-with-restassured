Feature: Login to Conduit Application

  Scenario: Login with correct credentials
    Given Saurabh is a writer and has an account on conduit application
    When Saurabh enters the credential as "saurabh@fake.com" and "fake"
    Then Saurabh gets access to the application

  Scenario: Login with correct credentials as list
    Given Saurabh is a writer and has an account on conduit application
    When Saurabh enters the credential as
      | saurabh@fake.com |
      | fake             |
    Then Saurabh gets access to the application

  Scenario: Login with correct credentials as map
    Given Saurabh is a writer and has an account on conduit application
    When Saurabh enters the credential as map
      | email    | saurabh@fake.com |
      | password | fake             |
    Then Saurabh gets access to the application

  Scenario: Login with correct credentials as vertical map
    Given Saurabh is a writer and has an account on conduit application
    When Saurabh enters the credential as vertical map
      | email            | password |
      | saurabh@fake.com | fake     |
    Then Saurabh gets access to the application

  Scenario Outline: Login with correct credentials as vertical map
    Given Saurabh is a writer and has an account on conduit application
    When Saurabh enters the credential as vertical map
      | email       | password       |
      | <userEmail> | <userPassword> |
    Then Saurabh gets access to the application

    Examples: 
      | userEmail        | userPassword |
      | saurabh@fake.com | fake         |
      | saurabh@see.com  | fake         |
      | saurabh@ff.com   | fake         |
