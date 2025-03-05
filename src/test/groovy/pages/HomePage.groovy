package pages

import geb.Page
import org.openqa.selenium.By

class HomePage extends Page {
    static url = 'https://www.demoblaze.com/'

    static at = {
        sleep(2000);
        waitFor { logo.isDisplayed() }
    }

    static content = {
        logo { $(By.id('nava')) }
        login(to: LoginPage) { $(By.id('login2')) }
        logout(to: HomePage) { $(By.id('logout2')) }

        phones(to: HomePage) { $('a', text: 'Phones') }
        laptops(to: HomePage) { $('a', text: 'Laptops') }
        monitors(to: HomePage) { $('a', text: 'Monitors') }

        cardTitle(to: HomePage) { $('h4', class: 'card-title') }
    }

    boolean isProductPresent(String searchFor) {
        cardTitle.find { current ->
            if (current.text() == searchFor) {
                return true;
            }
        }
    }

}
