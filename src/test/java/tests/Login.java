package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AuthenticationPage;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.PasswordRecoveryPage;

public class Login extends BaseTest {

    AuthenticationPage ap = new AuthenticationPage(driver);
    final String validEmail = "aaa323231@gmail.com";
    final String validPassword = "uxpEY7VbTWp8J@a";
    final String inValidEmail = "InvalidMail";
    final String invalidPassword = "1234";
    final String expectedWrongEmail = "Invalid email address.";
    final String expectedWrongPassword = "Invalid password.";
    final String UnregisteredEmail = "NotRegisteredx199@gmail.com";

    @Test(description = "Sign in using valid email and password")
    public void tc01_SignIn() {
        HomePage hp = new HomePage(driver);
        hp.navToSignIn();
        AuthenticationPage ap = new AuthenticationPage(driver);
        ap.SignIn(validEmail, validPassword);
        String expected = utils.readProperty("myAccountURL");
        String actual = hp.getURL();
        Assert.assertEquals(actual, expected);
        hp.signOut();


    }

    @Test(description = "try to sign in with invalid email")
    public void tc02_SignInInvalidEmail() {
        AuthenticationPage ap = new AuthenticationPage(driver);
        ap.SignIn(inValidEmail, validPassword);
        String ActualEmailNotifcation = ap.getSignInError().getText();
        Assert.assertEquals(ActualEmailNotifcation, expectedWrongEmail);
    }

    @Test(description = "try to sign in with invalid password")
    public void tc03_SignInInvalidPassword() {
        HomePage hp = new HomePage(driver);
        hp.navToSignIn();
        AuthenticationPage ap = new AuthenticationPage(driver);
        ap.SignIn(validEmail,invalidPassword);
        String ActualEmailNotifcation = ap.getSignInError().getText();
        Assert.assertEquals(ActualEmailNotifcation, expectedWrongPassword);
    }

    @Test(description = "Password recovery flow valid")
    public void tc04_PasswordRecovery() {
        //Nav to passwordRecoveryPage
        AuthenticationPage ap = new AuthenticationPage(driver);
        BasePage bp = new BasePage(driver);
        bp.click( ap.getForgotPassword());
        PasswordRecoveryPage prp = new PasswordRecoveryPage(driver);
        prp.PasswordRecovery(validEmail);
        String ExpectedPWrecoveryNotification = prp.getValidReocveryNotification();
        String ActualPWRecoveryNotification = prp.getRetrievePWNotification().getText();
        Assert.assertEquals(ActualPWRecoveryNotification, ExpectedPWrecoveryNotification);
        prp.ClickBackToLogin();
        bp.click( ap.getForgotPassword());
    }

    @Test(description = "Try to recover password with invalid email")
    public void tc05_PasswordRecoveryUnregisteredMail() {
        PasswordRecoveryPage prp = new PasswordRecoveryPage(driver);
        prp.PasswordRecovery(inValidEmail);
        String ExpectedInvalidEmailNotification = prp.getInvalidRecoveryNotification2();
        String ActualPWRecoveryNotification = prp.getFailRecoveryMsg().getText();
        Assert.assertEquals(ActualPWRecoveryNotification,ExpectedInvalidEmailNotification);
    }




}
