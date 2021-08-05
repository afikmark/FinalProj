package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AuthenticationPage extends BasePage {
    @FindBy(css="#create-account_form ")
    WebElement createAccBox;
    @FindBy(css="#email_create")
    WebElement emailAddressField;
    @FindBy (css=".icon-user.left")
    WebElement CreateAccBtn;
    //SignIn form
    @FindBy (css="#email")
    WebElement emailAddressSignIn;
    @FindBy (css="#passwd")
    WebElement PasswordSignIn;
    @FindBy (css="#SubmitLogin")
    WebElement SignInBtn;
    @FindBy (css=".lost_password.form-group a")
    WebElement forgotPassword;
    //CreateAccount
    @FindBy (css="#uniform-id_gender1")
    WebElement male;
    @FindBy (css="#uniform-id_gender2")
    WebElement female;
    @FindBy (css="#customer_firstname")
    WebElement FirstName;
    @FindBy (css="#customer_lastname")
    WebElement LastName;
    @FindBy (css="#email")
    WebElement Email;
    @FindBy (css="#passwd")
    WebElement Password;
    @FindBy (css="#days")
    WebElement Day;
    @FindBy (css="#months")
    WebElement Month;
    @FindBy (css="#years")
    WebElement Year;
    @FindBy (css="#newsletter")
    WebElement Checkbox1;
    @FindBy (css="#optin")
    WebElement Checkbox2;
    @FindBy (css="#company")
    WebElement Company;
    @FindBy (css="#address1")
    WebElement Address;
    @FindBy (css="#address2")
    WebElement Address2;
    @FindBy (css="#city")
    WebElement City;
    @FindBy (css="#id_state")
    WebElement State;
    @FindBy (css="#postcode")
    WebElement Zip;
    @FindBy (css="#id_country")
    WebElement Country;
    @FindBy (css="#other")
    WebElement AdditionalInfo;
    @FindBy (css="#phone")
    WebElement Homephone;
    @FindBy (css="#phone_mobile")
    WebElement Mobilephone;
    @FindBy (css="#alias")
    WebElement Alias;
    @FindBy (css="#submitAccount")
    WebElement RegBtn;
    @FindBy (css="#create_account_error>ol>li")
    WebElement createAccError;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }
}
