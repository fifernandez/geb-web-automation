package support.steps

import org.openqa.selenium.Keys
import org.openqa.selenium.interactions.Actions
import pages.GoogleResultsPage
import io.cucumber.groovy.EN

this.metaClass.mixin(EN)

And(~/^On the 'Google Home' page, in the '(.*)' I type: '(.*)'/) { String field, value ->
    switch (field) {
        case 'Search Text':
            page.searchText << value
            break
        default:
            println 'Field not recognized'
            assert false
    }
}

And(~/^On the 'Google Home' page, I click on: '((?:Search Button))'/) { String button ->
    switch (button) {
        case 'Search Button':
            //page.searchButton.click()
            Actions action = new Actions(browser.driver)
            action.sendKeys(Keys.ENTER).build().perform()
            at GoogleResultsPage
            break
    }
}