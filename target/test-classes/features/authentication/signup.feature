Feature: User Signup Process
  As a new user
  I want to sign up on the e-commerce web


Scenario: Sign up on the e-commerce web
  Given the new user navigates to the ecommerce web
  And is on sign up page
  When the new user enter a valid and unique username
  And the new user enter a valid and unique password
  And the new user clicks on the sign up button
  Then the new user watch an successful registration message



