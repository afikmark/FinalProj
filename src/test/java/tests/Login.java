package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AuthenticationPage;
import pageObjects.HomePage;
import pageObjects.PasswordRecoveryPage;
import utils.AllureAttachment;

public class Login extends BaseTest {

    final String validEmail = "aaa323231@gmail.com";
    final String validPassword = "uxpEY7VbTWp8J@a";
    final String inValidEmail = "InvalidMail";
    final String invalidPassword = "1234";
    final String expectedInvalidEmail = "Invalid email address.";
    final String expectedWrongPassword = "Invalid password.";
    final String UnregisteredEmail = "NotRegisteredx199@gmail.com";

    public String getValidEmail() {
        return validEmail;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInValidEmail() {
        return inValidEmail;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public String getExpectedInvalidEmail() {
        return expectedInvalidEmail;
    }

    public String getExpectedWrongPassword() {
        return expectedWrongPassword;
    }

    public String getUnregisteredEmail() {
        return UnregisteredEmail;
    }

    @Test(description = "Sign in using valid email and password")
    @Description("Sign in using valid email and password")
    @Severity(SeverityLevel.CRITICAL)
    public void tc01_SignIn() {
        var homePage = new HomePage(driver);
        homePage.navToSignIn();
        var authenticationPage = new AuthenticationPage(driver);
        authenticationPage.SignIn(validEmail, validPassword);
        var expected = utils.readProperty("myAccountURL");
        var actual = homePage.getURL();
        Assert.assertEquals(actual, expected);
        homePage.signOut();
        AllureAttachment.addTextAttachment("Signed in and out successfully");
    }

    @Test(description = "try to sign in with invalid email")
    @Description("try to sign in with invalid email")
    @Severity(SeverityLevel.NORMAL)
    public void tc02_SignInInvalidEmail() {
        var authenticationPage = new AuthenticationPage(driver);
        authenticationPage.SignIn(inValidEmail, validPassword);
        var ActualEmailNotifcation = authenticationPage.getSignInError().getText();
        Assert.assertEquals(ActualEmailNotifcation, expectedInvalidEmail);
    }

    @Test(description = "try to sign in with invalid password")
    @Description("try to sign in with invalid password")
    @Severity(SeverityLevel.NORMAL)
    public void tc03_SignInInvalidPassword() {
        var homePage = new HomePage(driver);
        homePage.navToSignIn();
        var authenticationPage = new AuthenticationPage(driver);
        authenticationPage.SignIn(validEmail,invalidPassword);
        var ActualEmailNotifcation = authenticationPage.getSignInErrorText();
        Assert.assertEquals(ActualEmailNotifcation, expectedWrongPassword);
    }

    @Test(description = "Password recovery flow valid")
    @Description("Password recovery flow valid")
    @Severity(SeverityLevel.CRITICAL)
    public void tc04_PasswordRecovery() {
        var authenticationPage = new AuthenticationPage(driver);
        authenticationPage.click( authenticationPage.getForgotPassword());
        PasswordRecoveryPage prp = new PasswordRecoveryPage(driver);
        prp.PasswordRecovery(validEmail);
        String ExpectedPWrecoveryNotification = prp.getValidReocveryNotification();
        String ActualPWRecoveryNotification = prp.getRetrievePWNotification().getText();
        Assert.assertEquals(ActualPWRecoveryNotification, ExpectedPWrecoveryNotification);
        prp.ClickBackToLogin();
        authenticationPage.click( authenticationPage.getForgotPassword());
    }

    @Test(description = "Try to recover password with invalid email")
    @Description("Try to recover password with invalid email")
    @Severity(SeverityLevel.MINOR)
    public void tc05_PasswordRecoveryUnregisteredMail() {
        PasswordRecoveryPage prp = new PasswordRecoveryPage(driver);
        prp.PasswordRecovery(inValidEmail);
        String ExpectedInvalidEmailNotification = prp.getInvalidRecoveryNotification2();
        String ActualPWRecoveryNotification = prp.getFailRecoveryMsg().getText();
        Assert.assertEquals(ActualPWRecoveryNotification,ExpectedInvalidEmailNotification);
    }




}
