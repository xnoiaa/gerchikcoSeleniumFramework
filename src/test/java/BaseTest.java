import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public  class BaseTest {

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void getBaseLktUrl(String Url) {
        getWebDriver().get("http://localhost:3000" + Url);
    }

    public void getBaseLktUrl() {
        getWebDriver().get("http://localhost:3000");
    }

    @Before
    public void driverSetUp() {

        ChromeOptions options = new ChromeOptions ();
        options.addArguments ("/0.1.6_0");
        //options.addArguments("--lang=es");

        System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(getWebDriver(),3);
    }

    @After
    public void driverTearDown() {
        webDriver.close();
        webDriver.quit();
    }
}
