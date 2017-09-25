@Google

Feature: Google Search

  @Boca
  Scenario: Search only For Boca Juniors
    Given I go to the 'Google Home' page
    And On the 'Google Home' page, in the 'Search Text' I type: 'Boca Juniors'
    And On the 'Google Home' page, I click on: 'Search Button'
    Then The first result must contain the text 'Sitio Oficial Club Atlético Boca Juniors'
    And On the 'Results' page, I click on the one that says: 'Sitio Oficial Club Atlético Boca Juniors'
    Then The title of the page is 'Sitio Oficial Club Atlético Boca Juniors'


  @Others
  Scenario Outline: Search for Other Teams
    Given I go to the 'Google Home' page
    And On the 'Google Home' page, in the 'Search Text' I type: '<Team>'
    And On the 'Google Home' page, I click on: 'Search Button'
    Then The first result must contain the text '<LinkText>'
    And On the 'Results' page, I click on: 'The first result'
    Then The title of the page is '<SiteTitle>'

    Examples:
      | Team         | LinkText                                                          | SiteTitle                                                         |
      | Barcelona FC | FC Barcelona Web Oficial - Barça \| FCBarcelona.es - FC Barcelona | FC Barcelona Web Oficial - Barça \| FCBarcelona.es - FC Barcelona |
      | Real Madrid  | Real Madrid CF \| Web Oficial                                     | Real Madrid CF \| Web Oficial                                     |