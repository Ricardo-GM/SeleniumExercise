Feature: User Login and Logout Process
  As a user
  I want to login and logout on the e-commerce web

  Scenario Outline:Login succesfully in the e-commerce web with valid <username> & <password> and log out
    Given the new user navigates to the e-commerce web
    And is on log in page
    When the new user enter "<username>" as a username
    And the new user enter a "<password>" as a password
    And the new user clicks on the log in button
    Then the new user watch the welcome text in the nav
    And the new user click on the log out button

    Examples:
    |username|password|
    |pruebabaufest1|123|
    |pruebabaufest2|123|

