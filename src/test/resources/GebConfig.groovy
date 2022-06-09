import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.safari.SafariDriver

environments {

    firefox = {
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true")
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null")
        driver = new FirefoxDriver()
    }

    chrome {
        driver = { new ChromeDriver() }
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
            timeout = 3
            retryInterval = 0.1
        }

    }
}