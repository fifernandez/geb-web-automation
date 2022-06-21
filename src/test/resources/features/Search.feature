@Google

Feature: Google Search


  @prod
  @Boca
  Scenario: Search only For Boca Juniors
    Given I go to the 'Google Home' page
    And On the 'Google Home' page, in the 'Search Text' I type: 'Boca Juniors'
    And On the 'Google Home' page, I click on: 'Search Button'
    Then The first result must contain the text 'Boca'
    And On the 'Results' page, I click on: 'The first result'
    Then The title of the page must contain 'Boca'


  @Others
  Scenario Outline: Search for Other Teams
    Given I go to the 'Google Home' page
    And On the 'Google Home' page, in the 'Search Text' I type: '<Team>'
    And On the 'Google Home' page, I click on: 'Search Button'
    Then The first result must contain the text '<LinkText>'
    And On the 'Results' page, I click on: 'The first result'
    Then The title of the page must contain '<SiteTitle>'

    Examples:
      | Team            | LinkText        | SiteTitle       |
      | Manchester City | Manchester City | Manchester City |
      | Real Madrid     | Real Madrid     | Real Madrid     |