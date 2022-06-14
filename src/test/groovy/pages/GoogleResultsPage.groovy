package pages

import geb.Page
import org.openqa.selenium.By

class GoogleResultsPage extends Page {

    static at = {
        waitFor(10) { resultsCount.isDisplayed() }
        sleep(2000)
    }

    static content = {
        resultsCount { $(By.id('result-stats')) }
        allResults { $('div', class: 'g').find('h3') }
    }

}
