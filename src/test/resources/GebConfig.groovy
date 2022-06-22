import config.Configuration
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.safari.SafariDriver
import support.Environment
import java.util.logging.Level
import java.util.logging.Logger

Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF)
Configuration.loadAllConfigs()
Environment.getEnvironment()

environments {
    chrome {
        driver = {
            ChromeDriverService chromeDriverService = ChromeDriverService.createDefaultService()
            chromeDriverService.sendOutputTo(new FileOutputStream("/dev/null"))
            DesiredCapabilities caps = new DesiredCapabilities()
            WebDriver driver
            if ((!isRemote()) && (!isHeadless())) {
                driver = new ChromeDriver(chromeDriverService)
            } else if (isHeadless()) {
                ChromeOptions chromeOptions = new ChromeOptions()
                chromeOptions.addArguments("--headless")
                driver = new ChromeDriver(chromeDriverService, chromeOptions)
            } else {
                caps.setCapability("os", "Windows")
                caps.setCapability("os_version", "10")
                caps.setCapability("browser", "Chrome")
                caps.setCapability("browserstack.use_w3c", "true")
                driver = buildRemoteDriver(caps)
            }
            configsForAll(driver)
            driver
        }
    }

    firefox {
        driver = {
            WebDriver driver
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true")
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null")
            if ((!isRemote()) && (!isHeadless())) {
                driver = new FirefoxDriver()
            } else if (isHeadless()) {
                FirefoxOptions firefoxOptions = new FirefoxOptions()
                firefoxOptions.addArguments("--headless")
                driver = new FirefoxDriver(firefoxOptions)
            } else {
                DesiredCapabilities caps = new DesiredCapabilities()
                caps.setCapability("os", "Windows")
                caps.setCapability("os_version", "10")
                caps.setCapability("browser", "Firefox")
                driver = buildRemoteDriver(caps)
            }
            configsForAll(driver)
            driver
        }
    }

    safari {
        driver = {
            WebDriver driver
            if (!isRemote()) {
                driver = new SafariDriver()
            } else {
                DesiredCapabilities caps = new DesiredCapabilities()
                caps.setCapability("os", "OS X")
                caps.setCapability("os_version", "High Sierra")
                caps.setCapability("browser", "Safari")
                driver = buildRemoteDriver(caps)
            }
            configsForAll(driver)
            driver
        }
    }
}

waiting {
    presets {
        superslow {
            timeout = 60
            retryInterval = 1
        }
        slowest {
            timeout = 25
            retryInterval = 1
        }
        medium {
            timeout = 20
            retryInterval = 1
        }
        normal {
            timeout = 15
            retryInterval = 1
        }
        quick {
            timeout = 10
            retryInterval = 1
        }
    }
    includeCauseInMessage = true
}

boolean isRemote() {
    String option = System.getProperty('browser.option')
    if ((option == null) || (option != 'remote')) {
        return false
    } else {
        return true
    }
}

boolean isHeadless() {
    String option = System.getProperty('browser.option')
    if ((option == null) || (option != 'headless')) {
        return false
    } else {
        return true
    }
}

void configsForAll(WebDriver driver) {
    driver.manage().window().maximize()
}

WebDriver buildRemoteDriver(DesiredCapabilities caps) {
    String user = ''
    String key = ''
    String url = "https://${user}:${key}@hub.browserstack.com/wd/hub"
    caps.setCapability("project", "test")
    caps.setCapability("browserstack.local", "false")
    caps.setCapability("browserstack.selenium_version", "3.141.59")
    caps.setCapability("browserstack.idleTimeout", "300")
    caps.setCapability("browserstack.video", "false")
    //caps.setCapability("browserstack.timezone", "Los_Angeles")
    caps.setCapability("browser_version", "latest")
    caps.setCapability("resolution", "1920x1080")
    URL browserStackURL = new URL(url)
    def driver = new RemoteWebDriver(browserStackURL, caps)
    driver
}