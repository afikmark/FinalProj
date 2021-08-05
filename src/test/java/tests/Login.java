package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;

public class Login extends BaseTest {


    @Test
    public void SignUpValid() {
        HomePage hp = new HomePage(driver);
        hp.SignUp(u.readProperty("Email"), u.readProperty("FirstName"), u.readProperty("LastName"),
                u.readProperty("Password"), 3, 10, 31,
                u.readProperty("Company"), u.readProperty("Address"), u.readProperty("Address2"),
                u.readProperty("City"), 5, 1, u.readProperty("Zip"),
                u.readProperty("AddtionalInfo"), u.readProperty("HomePhone"),
                u.readProperty("MobilePhone"), u.readProperty("Alias"));
    }

    @Test
    public void InvalidEmail() {
        HomePage hp = new HomePage(driver);
        hp.SignupInvalidMail(u.readProperty("InvalidEmail"));
    }

    @Test
    public void UsedMail() {
        HomePage hp = new HomePage(driver);
        hp.SignUpUsedEmail(u.readProperty("usedEmail"));
    }

    @Test
    public void SignUpInvalid() {
        HomePage hp = new HomePage(driver);
        hp.SignUpInvalid(u.readProperty("Email"), u.readProperty("InvalidFirstName"),
                u.readProperty("InvalidLastName")
                , u.readProperty("InvalidPassword"), u.readProperty("InvalidZip"),
                u.readProperty("InvalidHomePhone"), u.readProperty("InvalidMobilePhone"));
    }

    @Test
    public void SignInValid(){
        HomePage hp = new HomePage(driver);
        hp.SignIn(u.readProperty("SignInEmail"),u.readProperty("SignInPassword"));
    }
    @Test
    public void SignInInvalidEmail(){
        HomePage hp = new HomePage(driver);
        hp.SignInInvalidEmail(u.readProperty("InvalidEmail"),u.readProperty("SignInPassword"));
    }

    @Test
    public void SignInInvalidPW(){
        HomePage hp = new HomePage(driver);
        hp.SignInInvalidPW(u.readProperty("SignInEmail"),u.readProperty("InvalidPassword"));
    }

    @Test
    public void PasswordRecovery(){
        HomePage hp = new HomePage(driver);
        hp.PasswordRecovery(u.readProperty("SignInEmail"));
    }


}
