Feature: Application Login

  Scenario: Home page default login
    Given User is on login page
    When User enters username "maryann" and password "1234"
    Then Home page is populated
    And Cards are displayed
