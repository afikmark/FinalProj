package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AuthenticationPage;
import pageObjects.HomePage;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends BaseTest {


    final String InvalidFirstName = "19123123";
    final String InvalidLastName = "092819291";
    final String InvalidZip = "1212";
    final String InvalidHomePhone = "0312456";
    final String InvalidMobilePhone = "0";
    final String expectedUsedEmailError = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
    ArrayList<String> expectedErrorList = new ArrayList<String>();


    @Test(description = "Sign-up with valid information")
    @Description("Sign-up with valid information")
    public void SignUpValid() {
        var homePage = new HomePage(driver);
        homePage.navToSignIn();
        var authenticationPage = new AuthenticationPage(driver);
        var login = new Login();
        authenticationPage.SignUp(user, login.getValidEmail());
    }

    @Test(description = "Sign up with invalid form information")
    @Description("Sign up with invalid form information")
    public void SignUpInvalid() {
        expectedErrorList.add("lastname is invalid.");
        expectedErrorList.add("firstname is invalid.");
        expectedErrorList.add("passwd is invalid.");
        expectedErrorList.add("address1 is required.");
        expectedErrorList.add("city is required.");
        expectedErrorList.add("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
        expectedErrorList.add("This country requires you to choose a State.");
        var homePage = new HomePage(driver);
        AuthenticationPage ap = new AuthenticationPage(driver);
        homePage.navToSignIn();
        var login = new Login();
        ap.NavToSignUp(login.getUnregisteredEmail());
        List<String> actualErrorList = ap.SignUpInvalid(InvalidFirstName, InvalidLastName, login.getInvalidPassword(), InvalidZip, InvalidHomePhone, InvalidMobilePhone);
        Assert.assertEquals(expectedErrorList, actualErrorList);
    }

    @Test(description = "attempt to create an account with invalid email")
    @Description("attempt to create an account  invalid email")
    public void InvalidEmail() {
        var homePage = new HomePage(driver);
        var authenticationPage = new AuthenticationPage(driver);
        homePage.navToSignIn();
        var login = new Login();
        String actualError = authenticationPage.createAccount(login.getInValidEmail());
        Assert.assertEquals(actualError, login.getExpectedInvalidEmail());
    }

    @Test(description = "attempt to create an account  with used mail")
    @Description("attempt to create an account  used mail")
    public void UsedMail() {
        var homePage = new HomePage(driver);
        var authenticationPage = new AuthenticationPage(driver);
        homePage.navToSignIn();
        var login = new Login();
        String actualError = authenticationPage.createAccount(login.getValidEmail());
        Assert.assertEquals(actualError, expectedUsedEmailError);
    }

}



