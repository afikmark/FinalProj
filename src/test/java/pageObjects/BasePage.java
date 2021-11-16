package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils1;

import java.util.List;
import java.util.concurrent.TimeUnit;


public  class BasePage {
    WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }



    public void implicitWait(long timeunit) {
        driver.manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
    }

    public void explicitWaitVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicitWaitClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



    public void selectByValue(WebElement el, String Value) {
        Select s = new Select(el);
        s.selectByVisibleText(Value);
    }

    public void selectByText(WebElement el, String text) {
        Select s = new Select(el);
        s.selectByVisibleText(text);
    }

    public void selectByIndex(WebElement el, int i) {
        Select s = new Select(el);
        s.selectByIndex(i);

    }

    public void fillText(WebElement el, String text) {
        explicitWaitVisibility(el);
        el.clear();
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        explicitWaitClickable(el);
        el.click();
    }
    public void doubleClick(WebElement el){
        Actions action = new Actions(driver);
        action.doubleClick(el);
        action.build();
        action.perform();
    }

    public void MoveToElement(WebElement el){
        Actions action = new Actions(driver);
        action.moveToElement(el).build().perform();
    }


}
