package pages

import geb.Page
import org.openqa.selenium.By

class GoogleResultsPage extends Page {
    static at = {
        waitFor {resultsCount.isDisplayed()}
        sleep(2000)
    }

    static content = {
        resultsCount                { $(By.id('resultStats')) }
        allResults                  { $('div', class:'g').find('h3').find('a') }
    }

}
