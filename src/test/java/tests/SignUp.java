package tests;

import org.testng.annotations.Test;
import pageObjects.AuthenticationPage;
import pageObjects.HomePage;

public class SignUp extends Login{
    HomePage hp = new HomePage(driver);
    AuthenticationPage ap = new AuthenticationPage(driver);

    final String InvalidFirstName = "19123123";
    final String InvalidLastName = "092819291";
    final String InvalidZip = "1212";
    final String InvalidHomePhone = "0312456";
    final String InvalidMobilePhone = "0";

    @Test(description = "Sign-up with valid information")
    public void SignUpValid() {
        ap.SignUp(user);
    }

    @Test(description = "Sign up with invalid form information")
    public void SignUpInvalid() {
        ap.SignUpInvalid(inValidEmail, InvalidFirstName, InvalidLastName, invalidPassword, InvalidZip, InvalidHomePhone, InvalidMobilePhone);
    }

    @Test(description = "Sign up with invalid email")
    public void InvalidEmail() {
        ap.SignupInvalidMail(inValidEmail);
    }

    @Test(description = "Sign up with used mail")
    public void UsedMail() {
        ap.SignUpUsedEmail(validEmail);
    }

    @Test(description = "assert days selector in the sign up form ")
    public void AssertDays() {
        ap.AssertDaySelector(user, ap.getDayContainer());

    }

    @Test(description = "assert Months selector in the sign up form ")
    public void AssertMonths() {
        ap.AssertMonthSelector(user, ap.getMonthsContainer());


    }

    @Test(description = "assert Years selector in the sign up form ")
    public void AssertYears() {
        ap.AssertYearSelector(user, ap.getYearsContainer());


    }


}
