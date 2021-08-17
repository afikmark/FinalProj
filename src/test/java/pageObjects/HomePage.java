package pageObjects;

import entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Utils1;


import java.util.List;

public class HomePage extends BasePage {

    //Elements
    @FindBy(css = ".login")
    private  WebElement signInBtn;
    @FindBy(css = ".row .logout")
    private WebElement signOutBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navToSignIn(){
        click(signInBtn);
    }
    public void signOut(){
        click(signOutBtn);
    }

//    public void PasswordRecovery(String Email) {
//        AuthenticationPage ap = new AuthenticationPage(driver);
//        PasswordRecoveryPage pr = new PasswordRecoveryPage(driver);
//        //Nav to Sign in page
//        click(signInBtn);
//        //Click on "Forgot your password"
//        explicitWaitClickable(ap.forgotPassword);
//        click(ap.forgotPassword);
//        //Navigate to "ForgotYourPassword" page
//        //enter email
//        FillText(pr.emailAddress, Email);
//        //click on retrieve password
//        explicitWaitClickable(pr.retrievePasswordBtn);
//        click(pr.retrievePasswordBtn);
//        //assert notification
//        String ExpectedPWrecoveryNotification = utils.readProperty("ExpectedPWrecoveryNotification");
//        String ActualPWRecoveryNotification = pr.retrievePWNotification.getText();
//        Assert.assertEquals(ActualPWRecoveryNotification, ExpectedPWrecoveryNotification);
//        //click on back to login
//        explicitWaitClickable(pr.backToLoginBtn);
//        click(pr.backToLoginBtn);
//
//    }


}





