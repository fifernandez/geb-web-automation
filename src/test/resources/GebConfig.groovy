import org.openqa.selenium.firefox.FirefoxDriver

String device = System.properties.getProperty('device')

driver = {
    def driver = new FirefoxDriver()
    driver
}

environments {
    /*chrome {
        driver = { new CustomChromeDriver(device) }
    }*/
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