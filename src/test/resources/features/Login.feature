@DemoBlaze @Login

Feature: Log in

  @smoke @prod
  Scenario: Login a valid user
    Given I go to the 'Home' page
    And on the 'Home' page I click on: 'Log in'
    And on the 'Login' page I enter credentials for 'ff-test' user
    And on the 'Home' page the logout button should be visible