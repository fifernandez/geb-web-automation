package steps

import pages.GoogleHomePage
import static cucumber.api.groovy.EN.*

When(~/I go to the '((?:Google Home))' page/) { String page ->

    switch (page) {
        case 'Google Home':
            to GoogleHomePage
            break
    }

}

Then(~/The title of the page is '(.*)'/) { String correct ->

    assert page.title == correct

}
