package pages

import geb.Page
import org.openqa.selenium.By

class GoogleHomePage extends Page {
    static url = "http://www.google.com"

    static at = {
        waitFor { logo.isDisplayed() }
    }

    static content = {
        logo { $('img', class: 'lnXdpd') }
        searchText { $(By.name('q')) }
        searchButton(to: GoogleResultsPage) { $('input', 'title': 'Search') }
    }

}
