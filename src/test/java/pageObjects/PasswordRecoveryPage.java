package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordRecoveryPage extends AuthenticationPage {
    //forgotPasswordForm
    @FindBy(css="#email")
    WebElement emailAddress;
    @FindBy (css = "#form_forgotpassword button")
    WebElement retrievePasswordBtn;
    @FindBy (css=".alert.alert-success")
    WebElement retrievePWNotification;
    @FindBy (css=".clearfix.footer_links .btn")
    WebElement backToLoginBtn;
    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

}
