package pages

import geb.Page
import org.openqa.selenium.By

class GoogleResultsPage extends Page {
    static at = {
        waitFor {resultsCount.isDisplayed()}
    }

    static content = {
        resultsCount                { $(By.id('result-stats')) }
        allResults                  { $('div', class:'g').find('h3').find('a') }
    }

}
