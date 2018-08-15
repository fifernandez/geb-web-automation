import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.opera.OperaDriver
import org.openqa.selenium.opera.OperaOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.safari.SafariDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.ie.InternetExplorerDriver

driver = {
    System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true")
    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null")
    def driver = new FirefoxDriver()
    driver
}

environments {
    chrome {
        driver = { new ChromeDriver() }
    }

    iexplorer {
        driver = { new InternetExplorerDriver() }
    }

    opera {
        OperaOptions options = new OperaOptions()
        options.setBinary(System.getProperty('webdriver.opera.driver'))
        options.addArguments("--headless")
        options.addArguments("--no-sandbox")
        options.addArguments("--disable-dev-shm-usage")

        driver = { new OperaDriver(options) }
    }

    phantomjs {
        DesiredCapabilities caps = new DesiredCapabilities()
        caps.setJavascriptEnabled(true)
        caps.setCapability("phantomjs.binary.path", System.getProperty('webdriver.phantomjs.driver'))
        driver = { new PhantomJSDriver(caps) }
    }

    safari {
        driver = { new SafariDriver() }
    }

}

waiting {
    presets {
        slowest {
            timeout = 30
            retryInterval = 0.1
        }
        medium {
            timeout = 15
            retryInterval = 0.1
        }
        normal {
            timeout = 5
            retryInterval = 0.1
        }
        quick {
            timeout = 0
        }
    }
}