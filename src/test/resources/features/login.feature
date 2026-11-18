Feature: Login

  Scenario: Valid login shows the products screen
    Given the user is on the login screen
    When the user logs in with "standard_user" and "shop123"
    Then the products screen is displayed

  Scenario: Invalid password shows an error
    Given the user is on the login screen
    When the user logs in with "standard_user" and "wrong"
    Then the error "Invalid username or password" is shown