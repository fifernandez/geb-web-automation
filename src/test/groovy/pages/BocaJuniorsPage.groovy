package pages

import geb.Page
import org.openqa.selenium.By

class BocaJuniorsPage extends Page {

    static at = {
        sleep(3000)
    }

    static content = {
        logo { $(By.id('hplogo')) }
    }

}
