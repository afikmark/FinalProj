package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import utils.Utils1;

public class Login extends BaseTest {
    Utils1 u = new Utils1();

    @Test
    public void SignUpValid() {
        HomePage hp = new HomePage(driver);
        hp.SignUpValid(u.readProperty("Email"), u.readProperty("FirstName"), u.readProperty("LastName"),
                u.readProperty("Password"), 3, 10, 31,
                u.readProperty("Company"), u.readProperty("Address"), u.readProperty("Address2"),
                u.readProperty("City"), 5, 1, u.readProperty("Zip"),
                u.readProperty("AddtionalInfo"), u.readProperty("HomePhone"),
                u.readProperty("MobilePhone"), u.readProperty("Alias"));
    }
}
