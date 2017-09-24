package env

import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriverException
import geb.binding.BindingUpdater
import static cucumber.api.groovy.Hooks.*
import geb.Browser

def theBrowser = new Browser()
def bindingUpdater

Before() { scenario ->
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
}

After() { scenario ->
    if (scenario.failed) {
        try {
            scenario.embed(((TakesScreenshot) theBrowser.driver).getScreenshotAs(OutputType.BYTES), "image/png")
            scenario.write("<div style=\"background-color:white\"><p>URL:  <a href='$theBrowser.driver.currentUrl'>$theBrowser.driver.currentUrl</a></p></div>")
        } catch (WebDriverException e) {
        }
    }
    bindingUpdater.remove()
}