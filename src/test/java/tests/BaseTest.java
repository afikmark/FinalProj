package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.internal.Utils;
import utils.Utils1;


public class BaseTest {
    Utils1 u = new Utils1();
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebSelenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(u.readProperty("url"));
        String url = driver.getCurrentUrl();
        if (!url.contains(u.readProperty("url"))) {
            driver.quit();
            driver.get(u.readProperty("url"));
        }

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    public String getURL() {
        return driver.getCurrentUrl();

    }


}

