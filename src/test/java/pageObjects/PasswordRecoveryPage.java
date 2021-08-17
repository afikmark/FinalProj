package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordRecoveryPage extends HomePage {
    //forgotPasswordForm
    @FindBy(css="#email")
    WebElement emailAddress;
    @FindBy (css = "#form_forgotpassword button")
    WebElement retrievePasswordBtn;
    @FindBy (css=".alert.alert-success")
    WebElement successRecoveryMsg;
    @FindBy (css=".alert-danger")
    WebElement failRecoveryMsg;

    public WebElement getSuccessRecoveryMsg() {
        return successRecoveryMsg;
    }

    public WebElement getFailRecoveryMsg() {
        return failRecoveryMsg;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getRetrievePasswordBtn() {
        return retrievePasswordBtn;
    }

    public WebElement getBackToLoginBtn() {
        return backToLoginBtn;
    }

    @FindBy (css=".clearfix.footer_links .btn")
    WebElement backToLoginBtn;
    //Notifications
    final String validReocveryNotification ="A confirmation email has been sent to your address: aaa323231@gmail.com";
    final String invalidReocveryNotification = "There is no account registered for this email address.";
    final String invalidRecoveryNotification2 ="There is 1 error"+"\r\n"+"Invalid email address.";

    public String getInvalidRecoveryNotification2() {
        return invalidRecoveryNotification2;
    }

    public WebElement getRetrievePWNotification() {
        return successRecoveryMsg;
    }

    public String getExpectedPWRecoveryNotification() {
        return validReocveryNotification;
    }



    public String getValidReocveryNotification() {
        return validReocveryNotification;
    }

    public String getInvalidReocveryNotification() {
        return invalidReocveryNotification;
    }


    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }


    public void PasswordRecovery(String Email) {
        //enter email
        fillText(emailAddress, Email);
        //click on retrieve password
        click(retrievePasswordBtn);
    }
    public void ClickBackToLogin(){
        click(backToLoginBtn);
    }


}
