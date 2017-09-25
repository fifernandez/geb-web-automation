package steps

import geb.navigator.Navigator

import static cucumber.api.groovy.EN.*

And(~/On the 'Google Home' page, in the '(.*)' I type: '(.*)'/) { String field, value ->
    switch (field) {
        case 'Search Text':
            page.searchText << value
            break
        default:
            println 'Field not recognized'
            assert false
    }
}

And(~/On the 'Google Home' page, I click on: '((?:Search Button))'/) { String button ->
    switch (button) {
        case 'Search Button':
            page.searchButton.click()
            break
    }
}