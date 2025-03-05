@DemoBlaze @Phones

Feature: Phones

  @regression @prod
  Scenario: Search for present phone
    Given I go to the 'Home' page
    And on the 'Home' page for categories I click on: 'Phones'
    And on the 'Home' page I should see a product with name 'Nexus 6'

  @regression @prod @this
  Scenario: Search for not present phone
    Given I go to the 'Home' page
    And on the 'Home' page for categories I click on: 'Phones'
    And on the 'Home' page I should not see a product with name 'Invalid Phone'