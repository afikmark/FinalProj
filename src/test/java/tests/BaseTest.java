package tests;

import entity.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pageObjects.HomePage;
import utils.Utils1;

import java.io.File;
import java.io.IOException;

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
    public void setup(ITestContext testContext) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(utils.readProperty("url"));
        testContext.setAttribute("WebDriver", this.driver);
    }
    @AfterMethod
    public void failedTest(ITestResult result) {
        //check if the test failed
        if (result.getStatus() == ITestResult.FAILURE ){
            TakesScreenshot ts = (TakesScreenshot)driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName() +".jpg"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //result.getname() method will give you current test case name.
            //./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
        }
    }



    public String checkCategory(){
        HomePage hp = new HomePage(driver);
       String categoryName = hp.getCategoryName().getText();
       return  categoryName;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

