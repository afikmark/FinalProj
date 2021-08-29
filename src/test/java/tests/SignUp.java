package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AuthenticationPage;
import pageObjects.HomePage;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends Login {


    final String InvalidFirstName = "19123123";
    final String InvalidLastName = "092819291";
    final String InvalidZip = "1212";
    final String InvalidHomePhone = "0312456";
    final String InvalidMobilePhone = "0";
    final String expectedUsedEmailError = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
    ArrayList<String> expectedErrorList = new ArrayList<String>();


//   expectedErrorList.add("lastname is invalid.");
//1 = firstname is invalid.
//2 = passwd is invalid.
//3 = address1 is required.
//4 = city is required.
//5 = The Zip/Postal code you've entered is invalid. It must follow this format: 00000
//            6 = This country requires you to choose a State.

    @Test(description = "Sign-up with valid information")
    public void SignUpValid() {
        HomePage hp = new HomePage(driver);
        AuthenticationPage ap = new AuthenticationPage(driver);
        hp.navToSignIn();
        ap.SignUp(user);
    }

    @Test(description = "Sign up with invalid form information")
    public void SignUpInvalid() {
        expectedErrorList.add("lastname is invalid.");
        expectedErrorList.add("firstname is invalid.");
        expectedErrorList.add("passwd is invalid.");
        expectedErrorList.add("address1 is required.");
        expectedErrorList.add("city is required.");
        expectedErrorList.add("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
        expectedErrorList.add("This country requires you to choose a State.");
        HomePage hp = new HomePage(driver);
        AuthenticationPage ap = new AuthenticationPage(driver);
        hp.navToSignIn();
        ap.NavToSignUp(UnregisteredEmail);
        List<String> actualErrorList = ap.SignUpInvalid(InvalidFirstName, InvalidLastName, invalidPassword, InvalidZip, InvalidHomePhone, InvalidMobilePhone);
        Assert.assertEquals(expectedErrorList,actualErrorList);
    }

    @Test(description = "Sign up with invalid email")
    public void InvalidEmail() {
        HomePage hp = new HomePage(driver);
        AuthenticationPage ap = new AuthenticationPage(driver);
        hp.navToSignIn();
        String actualError = ap.SignupInvalidMail(inValidEmail);
        Assert.assertEquals(actualError, expectedInvalidEmail);
    }

    @Test(description = "Sign up with used mail")
    public void UsedMail() {
        HomePage hp = new HomePage(driver);
        AuthenticationPage ap = new AuthenticationPage(driver);
        hp.navToSignIn();
       String actualError = ap.SignUpUsedEmail(validEmail);
       Assert.assertEquals(actualError,expectedUsedEmailError);
    }

}



