package support.env

import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriverException
import geb.binding.BindingUpdater
import geb.Browser
import io.cucumber.groovy.Hooks
import io.cucumber.groovy.Scenario
this.metaClass.mixin(Hooks)

def theBrowser = new Browser()
def bindingUpdater

Before() { ->
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
}

After() { Scenario scenario ->
    if (scenario.failed) {
        try {
            scenario.attach(((TakesScreenshot) theBrowser.driver).getScreenshotAs(OutputType.BYTES), "image/png", "")
        } catch (WebDriverException e) {
        }
    }
    bindingUpdater.remove()
}