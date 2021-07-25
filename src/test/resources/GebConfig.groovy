

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

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