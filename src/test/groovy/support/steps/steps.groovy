package support.steps

import pages.GoogleHomePage
import io.cucumber.groovy.EN

this.metaClass.mixin(EN)

When(~/^I go to the '(Google Home)' page$/) { String page ->
    switch (page) {
        case 'Google Home':
            to GoogleHomePage
            break
    }
}

Then(~/^The title of the page must contain '(.*)'$/) { String correct ->
    assert page.title.toLowerCase().contains(correct.toLowerCase())
}
