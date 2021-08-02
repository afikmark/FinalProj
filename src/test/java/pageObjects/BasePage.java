package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void FillText(WebElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        el.click();
    }

    public void implicitWait(long timeunit) {
        driver.manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
    }

    public void explicitWaitVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicitWaitClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void SelectByValue(WebElement el, String Value) {
        Select s = new Select(el);
        s.selectByVisibleText(Value);
    }

    public void SelectByText(WebElement el, String text) {
        Select s = new Select(el);
        s.selectByVisibleText(text);

    }

    public void SelectByIndex(WebElement el, int i) {
        Select s = new Select(el);
        s.selectByIndex(i);

    }
}
