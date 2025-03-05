package pages

import geb.Page
import org.openqa.selenium.By

class LoginPage extends Page {

    static at = {
        waitFor { modalTitle.text() == 'Log in' }
    }

    static content = {
        modalTitle { $(By.id('logInModalLabel')) }
        username { $(By.id('loginusername')) }
        password { $(By.id('loginpassword')) }
        close { $('button', text: 'Close') }
        login(to: HomePage) { $('button', text: 'Log in') }
    }

    void loginUser(String user, String pass) {
        username << user;
        password << pass;
        login.click();
    }

}
