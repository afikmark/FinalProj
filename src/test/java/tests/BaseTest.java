package tests;

import entity.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Utils1;

public class BaseTest {

    WebDriver driver;
    Utils1 utils = new Utils1();

    User user = new User(utils.readProperty("Email"), utils.readProperty("FirstName"), utils.readProperty("LastName"),
            utils.readProperty("Password"), 3, 10, 31,
            utils.readProperty("Company"), utils.readProperty("Address"), utils.readProperty("Address2"),
            utils.readProperty("City"), 5, 1, utils.readProperty("Zip"),
            utils.readProperty("AddtionalInfo"), utils.readProperty("HomePhone"),
            utils.readProperty("MobilePhone"), utils.readProperty("Alias"));


    @BeforeClass
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "C:\\WebSelenium\\chromedriver_win32\\chromedriver.exe");
//        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(utils.readProperty("url"));
        String title = driver.getTitle();
        if (utils.readProperty("PageTitle").equals(title)) {
            System.out.println("Title is correct " + title);
        } else {
            int attempts = 0;
            while (attempts < 3) {
                System.out.println("Error found, Restarting...");
                driver.quit();
                setup();
                attempts++;
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}

