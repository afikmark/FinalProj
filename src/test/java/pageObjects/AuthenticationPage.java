package pageObjects;

import entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationPage extends HomePage {


    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCreateAccBox() {
        return createAccBox;
    }

    public WebElement getEmailAddressField() {
        return emailAddressField;
    }

    public WebElement getCreateAccBtn() {
        return CreateAccBtn;
    }

    public WebElement getEmailAddressSignIn() {
        return emailAddressSignIn;
    }

    public WebElement getPasswordSignIn() {
        return PasswordSignIn;
    }

    public WebElement getSignInBtn() {
        return SignInBtn;
    }

    public WebElement getForgotPassword() {
        return forgotPassword;
    }

    public WebElement getSignInError() {
        return signInError;
    }

    public WebElement getMale() {
        return male;
    }

    public WebElement getFemale() {
        return female;
    }

    public WebElement getFirstName() {
        return FirstName;
    }

    public WebElement getLastName() {
        return LastName;
    }

    public WebElement getEmail() {
        return Email;
    }

    public WebElement getPassword() {
        return Password;
    }

    public WebElement getDay() {
        return Day;
    }

    public List<WebElement> getDayContainer() {
        return DayContainer;
    }

    public WebElement getMonth() {
        return Month;
    }

    public List<WebElement> getMonthsContainer() {
        return MonthsContainer;
    }

    public List<WebElement> getYearsContainer() {
        return YearsContainer;
    }

    public WebElement getYear() {
        return Year;
    }

    public WebElement getCheckbox1() {
        return Checkbox1;
    }

    public WebElement getCheckbox2() {
        return Checkbox2;
    }

    public WebElement getCompany() {
        return Company;
    }

    public WebElement getAddress() {
        return Address;
    }

    public WebElement getAddress2() {
        return Address2;
    }

    public WebElement getCity() {
        return City;
    }

    public WebElement getState() {
        return State;
    }

    public WebElement getZip() {
        return Zip;
    }

    public WebElement getCountry() {
        return Country;
    }

    public WebElement getAdditionalInfo() {
        return AdditionalInfo;
    }

    public WebElement getHomephone() {
        return Homephone;
    }

    public WebElement getMobilephone() {
        return Mobilephone;
    }

    public WebElement getAlias() {
        return Alias;
    }

    public WebElement getRegBtn() {
        return RegBtn;
    }

    public WebElement getCreateAccError() {
        return createAccError;
    }

    @FindBy(css = "#create-account_form ")
    WebElement createAccBox;
    @FindBy(css = "#email_create")
    WebElement emailAddressField;
    @FindBy(css = "#SubmitCreate")
    WebElement CreateAccBtn;
    //SignIn form
    @FindBy(css = "#email")
    WebElement emailAddressSignIn;
    @FindBy(css = "#passwd")
    WebElement PasswordSignIn;
    @FindBy(css = "#SubmitLogin")
    WebElement SignInBtn;
    @FindBy(css = ".lost_password.form-group a")
    WebElement forgotPassword;
    @FindBy(css = ".alert.alert-danger >ol")
    WebElement signInError;
    //CreateAccount
    @FindBy(css = "#uniform-id_gender1")
    WebElement male;
    @FindBy(css = "#uniform-id_gender2")
    WebElement female;
    @FindBy(css = "#customer_firstname")
    WebElement FirstName;
    @FindBy(css = "#customer_lastname")
    WebElement LastName;
    @FindBy(css = "#email")
    WebElement Email;
    @FindBy(css = "#passwd")
    WebElement Password;
    @FindBy(css = "#days")
    WebElement Day;
    @FindBy(css = "#days option")
    List<WebElement> DayContainer;
    @FindBy(css = "#months")
    WebElement Month;
    @FindBy(css = "#months option")
    List<WebElement> MonthsContainer;
    @FindBy(css = "#years")
    WebElement Year;
    @FindBy(css = "#years option")
    List<WebElement> YearsContainer;
    @FindBy(css = "#newsletter")
    WebElement Checkbox1;
    @FindBy(css = "#optin")
    WebElement Checkbox2;
    @FindBy(css = "#company")
    WebElement Company;
    @FindBy(css = "#address1")
    WebElement Address;
    @FindBy(css = "#address2")
    WebElement Address2;
    @FindBy(css = "#city")
    WebElement City;
    @FindBy(css = "#id_state")
    WebElement State;
    @FindBy(css = "#postcode")
    WebElement Zip;
    @FindBy(css = "#id_country")
    WebElement Country;
    @FindBy(css = "#other")
    WebElement AdditionalInfo;
    @FindBy(css = "#phone")
    WebElement Homephone;
    @FindBy(css = "#phone_mobile")
    WebElement Mobilephone;
    @FindBy(css = "#alias")
    WebElement Alias;
    @FindBy(css = "#submitAccount")
    WebElement RegBtn;
    @FindBy(css = "#create_account_error>ol>li")
    WebElement createAccError;

    //Todo: Remove Unecessary Navigations and clean up.
    public void SignUp(User user) {
        explicitWaitVisibility(createAccBox);
        fillText(emailAddressField, user.getEmail());
        click(CreateAccBtn);
        //Create an account
        //Choose gender
        click(female);
        click(male);
        //First name
        fillText(FirstName, user.getFirstName());
        //Last name
        fillText(LastName, user.getLastName());

        fillText(Password, user.getPassword());
        //Date of birth
        selectByIndex(Day, user.getDay());
        selectByIndex(Month, user.getMonth());
        selectByIndex(Year, user.getYear());
        //Checkbox1
        click(Checkbox1);
        //Checkbox2
        click(Checkbox2);
        //First name
        fillText(FirstName, user.getFirstName());
        //Last name
        fillText(LastName, user.getLastName());
        //Company
        fillText(Company, user.getCompany());
        //Address
        fillText(Address, user.getAddress());
        //Address(Line2)
        fillText(Address2, user.getAddress2());
        //City
        fillText(City, user.getCity());
        //State
        selectByIndex(State, user.getState());
        //Zip
        fillText(Zip, user.getZip());
        //Country
        selectByIndex(Country, user.getCountry());
        //Additional information
        fillText(AdditionalInfo, user.getAdditionalInfo());
        //Home Phone
        fillText(Homephone, user.getHomePhone());
        //Mobile phone
        fillText(Mobilephone, user.getMobilePhone());
        //Assign an address alias for future reference
        fillText(Alias, user.getAlias());
        //RegisterButton
//            click(RegBtn);

    }

    public String SignupInvalidMail(String Email) {
        fillText(emailAddressField, Email);
        click(CreateAccBtn);
        explicitWaitVisibility(createAccError);
        String errortxt = createAccError.getText();
        return errortxt;
    }

    public String SignUpUsedEmail(String Email) {
        fillText(emailAddressField, Email);
        click(CreateAccBtn);
        explicitWaitVisibility(createAccError);
        String errortxt = createAccError.getText();
        return errortxt;
    }

    public List<String> SignUpInvalid(String FirstName, String LastName, String Password, String Zip, String
            HomePhone, String MobilePhone) {
        //Choose gender - leave empty
        //First name
        fillText(this.FirstName, FirstName);
        //Last name
        fillText(this.LastName, LastName);
        //Password
        fillText(this.Password, Password);
        //Date of birth- leave empty
        //Checkbox1 - leave empty
        //Checkbox2 -leave empty
        //First name
        fillText(this.FirstName, FirstName);
        //Last name
        fillText(this.LastName, LastName);
        //Zip
        fillText(this.Zip, Zip);
        //Home Phone
        fillText(this.Homephone, HomePhone);
        //Mobile phone
        fillText(this.Mobilephone, MobilePhone);
        //RegisterButton
        click(this.RegBtn);
        List<WebElement> errorList = driver.findElements(By.cssSelector(".alert.alert-danger li"));
        ArrayList<String> errorListSTR = new ArrayList<String>();
        for (WebElement error : errorList) {
            String errorSTR = error.getText();
            errorListSTR.add(errorSTR);
        }
        return errorListSTR;
    }

    public void SignIn(String Email, String Password) {
        //Fill sign in credentials
        fillText(emailAddressSignIn, Email);
        fillText(PasswordSignIn, Password);
        click(getSignInBtn());
    }

    public void NavToSignUp(String Email) {
        fillText(emailAddressField, Email);
        click(CreateAccBtn);
    }


}


