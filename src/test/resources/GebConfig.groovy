import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.safari.SafariDriver

baseUrl = 'http://madison.craigslist.org'

// default driver...
driver = { new FirefoxDriver() }

environments {
    // specify environment via -Dgeb.env=ie
    'ie' {
        def ieDriver = new File('src/test/resources/IEDriverServer.exe')
        System.setProperty('webdriver.ie.driver', ieDriver.absolutePath)
        driver = { new InternetExplorerDriver() }
    }

    'chrome' {
        def chromeDriver = new File('src/test/resources/chromedriver.exe')
        System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
        driver = { new ChromeDriver() }
    }

    'ff' {
        driver = { new FirefoxDriver() }
        //driver.Manage().Window.Maximize()
    }

    'safari' {
        driver = { new SafariDriver() }
    }

}

waiting {
    timeout = 6
    retryInterval = 0.5
    slow { timeout = 12 }
    reallyslow { timeout = 24 }
}

reportsDir = "target/geb-reports"

