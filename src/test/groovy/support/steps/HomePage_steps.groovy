package support.steps

import io.cucumber.groovy.EN

this.metaClass.mixin(EN)

And(~/^on the 'Home' page I click on: '(Log in)'$/) { String button ->
    switch (button) {
        case 'Log in':
            page.login.click();
            break
    }
}
And(~/^on the 'Home' page the logout button should be visible$/) { ->
    page.logout.isDisplayed();
}
And(~/^on the 'Home' page for categories I click on: '(Phones|Laptops|Monitors)'$/) { String category ->
    switch (category) {
        case 'Phones':
            page.phones.click();
            break
        case 'Laptops':
            page.laptops.click();
            break
        case 'Monitors':
            page.monitors.click();
            break
    }
}

And(~/^on the 'Home' page I should see a product with name '(.*)'$/) { String product ->
    assert page.isProductPresent(product), "Verify ${product} is present"
}
And(~/^on the 'Home' page I should not see a product with name '(.*)'$/) { String product ->
    assert !page.isProductPresent(product), "Verify ${product} is not present"
}