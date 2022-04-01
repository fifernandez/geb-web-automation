package support.steps

import geb.navigator.Navigator
import pages.BocaJuniorsPage
import pages.UnknownPage
import io.cucumber.groovy.EN

this.metaClass.mixin(EN)

And(~/^On the 'Results' page, I click on: '(The first result)'$/) { String button ->
    switch (button) {
        case 'The first result':
            Navigator firstResult = page.allResults[0]
            firstResult.click()
            at UnknownPage
            break
    }
}

And(~/^On the 'Results' page, I click on the one that says: '(.*)'$/) { String searchValue ->
    for (i in 0..page.allResults.size() -1) {
        Navigator actual = page.allResults[i]
        if (actual.text() == searchValue) {
            actual.click()
            switch (searchValue){
                case 'Sitio Oficial Club Atlético Boca Juniors':
                    at BocaJuniorsPage
                    break
                default:
                    println 'Site not recognized'
                    assert false
            }
            break
        }
    }
}

Then(~/^The first result must contain the text '(.*)'$/) { String correct ->
    Navigator firstResult = page.allResults[0]
    assert firstResult.text().contains(correct)
}