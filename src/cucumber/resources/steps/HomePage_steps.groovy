package steps

import org.openqa.selenium.Keys
import org.openqa.selenium.interactions.Actions
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
    Actions action = new Actions(browser.driver)
    action.sendKeys(Keys.ESCAPE).build().perform()
    sleep(500)
    switch (button) {
        case 'Search Button':
            page.searchButton.click()
            break
    }
}