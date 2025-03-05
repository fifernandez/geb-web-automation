package support.steps

import io.cucumber.groovy.EN
import pages.HomePage
import pages.LoginPage

this.metaClass.mixin(EN)

When(~/^I go to the '(Home)' page$/) { String page ->
    switch (page) {
        case 'Home':
            to HomePage
            break
    }
}

Then(~/^The title of the page must contain '(.*)'$/) { String correct ->
    assert page.title.toLowerCase().contains(correct.toLowerCase())
}

And(~/^on the 'Login' page I enter credentials for 'ff-test' user$/) { ->
    page.loginUser('ff-test', '123456')
}