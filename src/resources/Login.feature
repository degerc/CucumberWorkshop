Feature: Login Functionality

  In order to use IMDB
  As a valid IMDB User
  I want to Login Successfully

# Scenario Example
  @Login
  Scenario: Login Successful

    Given I navigate to the IMDB home page on Chrome
    And Click on Sign In Button
    And Click Sign in with IMDB button on Sign In Page
    When I enter valid credentials
    Then I should be taken to the valid page

