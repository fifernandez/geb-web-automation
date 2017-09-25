package pages

import geb.Page
import org.openqa.selenium.By

class GoogleHomePage extends Page {
    static url = "http://www.google.com"
    static at = {
        waitFor {logo.isDisplayed()}
    }

    static content = {
        logo                                            { $(By.id('hplogo')) }
        searchText                                      { $(By.id('lst-ib')) }
        searchButton        (to: GoogleResultsPage)     { $(By.name('btnK')) }
    }

}
