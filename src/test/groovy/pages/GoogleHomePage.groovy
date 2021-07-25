package pages

import geb.Page
import org.openqa.selenium.By

class GoogleHomePage extends Page {
    static url = "http://www.google.com.ar"
    static at = {
        waitFor {logo.isDisplayed()}
    }

    static content = {
        logo                                            { $(By.id('hplogo')) }
        searchText                                      { $('input', 'aria-label':'Buscar') }
        searchButton        (to: GoogleResultsPage)     { $(By.name('btnK')) }
    }

}
