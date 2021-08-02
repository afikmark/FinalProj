package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    @FindBy (css=".footer_links.clearfix .btn")
    WebElement homeBtn;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

}
