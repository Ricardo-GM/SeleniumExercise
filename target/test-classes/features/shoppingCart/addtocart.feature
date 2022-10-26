Feature: User add a single article to cart
  In order to purchase an article later
  As a user
  I want to add a single article to shopping cart

  Scenario: User can add an article succesfully to shopping cart
    Given the user login on the e-commer web succesfully
    When the user clicks on the Laptops Category
    And the user adds the first item listed to the shopping cart
    Then the user see the item added on the shopping cart
    And the user log out of the e-commerce web