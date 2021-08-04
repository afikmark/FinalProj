package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import tests.BaseTest;
import utils.Utils1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import tests.BaseTest;
import utils.Utils1;

import java.util.List;

public class HomePage extends BasePage {


public class HomePage extends BasePage {


    //Elements
    @FindBy(css = ".login")
    WebElement signInBtn;
    @FindBy(css=".logout")
    WebElement signOutBtn;


    //Elements
    @FindBy(css = ".login")
    WebElement signInBtn;
    @FindBy(css=".logout")
    WebElement signOutBtn;


    public HomePage() {
        super();

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public HomePage() {
        super();
=======
    public HomePage(WebDriver driver) {
        super(driver);


    public void SignUp(String Email, String FirstName, String LastName, String Password, int Day, int Month, int Year, String Company, String Address, String Address2,
                       String City, int State, int Country, String Zip, String AdditionalInfo, String HomePhone, String MobilePhone, String Alias) {

    public void SignUp(String Email, String FirstName, String LastName, String Password, int Day, int Month, int Year, String Company, String Address, String Address2,
                       String City, int State, int Country, String Zip, String AdditionalInfo, String HomePhone, String MobilePhone, String Alias) {

        //enter email
        explicitWaitClickable(signInBtn);
        click(signInBtn);
        //Navigate to Authentication page
        AuthenticationPage ap = new AuthenticationPage(driver);
        explicitWaitVisibility(ap.createAccBox);
        FillText(ap.emailAddressField, Email);
        click(ap.CreateAccBtn);
        //Create an account
        //Choose gender
        explicitWaitClickable(ap.female);
        click(ap.female);
        explicitWaitClickable(ap.male);
        click(ap.male);
        //First name
        FillText(ap.FirstName, FirstName);
        //Last name
        FillText(ap.LastName, LastName);
        //Email
 
        //FillText(ap.Email, Email);

        //FillText(ap.Email, Email);

        //Password
        FillText(ap.Password, Password);
        //Date of birth
        SelectByIndex(ap.Day, Day);
        SelectByIndex(ap.Month, Month);
        SelectByIndex(ap.Year, Year);
        //Checkbox1
        click(ap.Checkbox1);
        //Checkbox2
        click(ap.Checkbox2);
        //First name
        FillText(ap.FirstName, FirstName);
        //Last name
        FillText(ap.LastName, LastName);
        //Company
        FillText(ap.Company, Company);
        //Address
        FillText(ap.Address, Address);
        //Address(Line2)
        FillText(ap.Address2, Address2);
        //City
        FillText(ap.City, City);
        //State
        SelectByIndex(ap.State, State);
        //Zip
        FillText(ap.Zip, Zip);
        //Country
        SelectByIndex(ap.Country, Country);
        //Additional information
        FillText(ap.AdditionalInfo, AdditionalInfo);
        //Home Phone
        FillText(ap.Homephone, HomePhone);
        //Mobile phone
        FillText(ap.Mobilephone, MobilePhone);
        //Assign an address alias for future reference
        FillText(ap.Alias, Alias);
        //RegisterButton
//            click(ap.RegBtn);
LoginTests

    }

    public void SignupInvalidMail(String Email) {
        explicitWaitClickable(signInBtn);
        click(signInBtn);
        //Navigate to Authentication page
        AuthenticationPage ap = new AuthenticationPage(driver);
        explicitWaitVisibility(ap.createAccBox);
        FillText(ap.emailAddressField, Email);
        click(ap.CreateAccBtn);
        explicitWaitVisibility(ap.createAccError);
        String errortxt = ap.createAccError.getText();
        Assert.assertEquals(errortxt, u.readProperty("InvalidMailmsg"));
    }

    public void SignUpUsedEmail(String Email) {
        explicitWaitClickable(signInBtn);
        click(signInBtn);
        BaseTest bt = new BaseTest();
//        bt.HandlePageLoad();
        //Navigate to Authentication page
        AuthenticationPage ap = new AuthenticationPage(driver);
        explicitWaitVisibility(ap.createAccBox);
        FillText(ap.emailAddressField, Email);
        click(ap.CreateAccBtn);
        explicitWaitVisibility(ap.createAccError);
        String errortxt = ap.createAccError.getText();
        Assert.assertEquals(errortxt, u.readProperty("UsedMailmsg"));

    }

    public void SignUpInvalid(String Email, String FirstName, String LastName, String Password, String Zip, String HomePhone, String MobilePhone) {
        //enter email
        explicitWaitClickable(signInBtn);
        click(signInBtn);
        //Navigate to Authentication page
        AuthenticationPage ap = new AuthenticationPage(driver);
        explicitWaitVisibility(ap.createAccBox);
        FillText(ap.emailAddressField, Email);
        click(ap.CreateAccBtn);
        explicitWaitVisibility(ap.RegBtn);
        //Create an account
        //Choose gender - leave empty
        //First name
        FillText(ap.FirstName, FirstName);
        //Last name
        FillText(ap.LastName, LastName);
        //Password
        FillText(ap.Password, Password);
        //Date of birth- leave empty
        //Checkbox1 - leave empty
        //Checkbox2 -leave empty
        //First name
        FillText(ap.FirstName, FirstName);
        //Last name
        FillText(ap.LastName, LastName);
        //Zip
        explicitWaitVisibility(ap.Zip);
        FillText(ap.Zip, Zip);
        //Home Phone
        FillText(ap.Homephone, HomePhone);
        //Mobile phone
        FillText(ap.Mobilephone, MobilePhone);
        //RegisterButton
        click(ap.RegBtn);
        List<WebElement> erorList = driver.findElements(By.cssSelector(".alert.alert-danger li"));
        for (int i = 0; i < erorList.size(); i++) {
            String iString =String.valueOf(i);
            String expectedErrorString = u.readProperty(iString);
            if (expectedErrorString != null)
                Assert.assertEquals(erorList.get(i).getText(), expectedErrorString);
        }

   
    }

    public void SignupInvalidMail(String Email) {
        explicitWaitClickable(signInBtn);
        click(signInBtn);
        //Navigate to Authentication page
        AuthenticationPage ap = new AuthenticationPage(driver);
        explicitWaitVisibility(ap.createAccBox);
        FillText(ap.emailAddressField, Email);
        click(ap.CreateAccBtn);
        explicitWaitVisibility(ap.createAccError);
        String errortxt = ap.createAccError.getText();
        Assert.assertEquals(errortxt, u.readProperty("InvalidMailmsg"));
    }

    public void SignUpUsedEmail(String Email) {
        explicitWaitClickable(signInBtn);
        click(signInBtn);
        BaseTest bt = new BaseTest();
//        bt.HandlePageLoad();
        //Navigate to Authentication page
        AuthenticationPage ap = new AuthenticationPage(driver);
        explicitWaitVisibility(ap.createAccBox);
        FillText(ap.emailAddressField, Email);
        click(ap.CreateAccBtn);
        explicitWaitVisibility(ap.createAccError);
        String errortxt = ap.createAccError.getText();
        Assert.assertEquals(errortxt, u.readProperty("UsedMailmsg"));

    }

    public void SignUpInvalid(String Email, String FirstName, String LastName, String Password, String Zip, String HomePhone, String MobilePhone) {
        //enter email
        explicitWaitClickable(signInBtn);
        click(signInBtn);
        //Navigate to Authentication page
        AuthenticationPage ap = new AuthenticationPage(driver);
        explicitWaitVisibility(ap.createAccBox);
        FillText(ap.emailAddressField, Email);
        click(ap.CreateAccBtn);
        explicitWaitVisibility(ap.RegBtn);
        //Create an account
        //Choose gender - leave empty
        //First name
        FillText(ap.FirstName, FirstName);
        //Last name
        FillText(ap.LastName, LastName);
        //Password
        FillText(ap.Password, Password);
        //Date of birth- leave empty
        //Checkbox1 - leave empty
        //Checkbox2 -leave empty
        //First name
        FillText(ap.FirstName, FirstName);
        //Last name
        FillText(ap.LastName, LastName);
        //Zip
        explicitWaitVisibility(ap.Zip);
        FillText(ap.Zip, Zip);
        //Home Phone
        FillText(ap.Homephone, HomePhone);
        //Mobile phone
        FillText(ap.Mobilephone, MobilePhone);
        //RegisterButton
        click(ap.RegBtn);
        List<WebElement> erorList = driver.findElements(By.cssSelector(".alert.alert-danger li"));
        for (int i = 0; i < erorList.size(); i++) {
            String iString =String.valueOf(i);
            String expectedErrorString = u.readProperty(iString);
            if (expectedErrorString != null)
                Assert.assertEquals(erorList.get(i).getText(), expectedErrorString);
        }
 main
    }
}
