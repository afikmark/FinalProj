    package pageObjects;

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.ui.Select;
    import utils.Utils1;

    public class HomePage extends BasePage {


        //Elements
        @FindBy(css = ".login")
        WebElement signInBtn;


        public HomePage(WebDriver driver) {
            super(driver);
        }


        public void SignUpValid(String Email, String FirstName, String LastName, String Password, int Day, int Month, int Year, String Company, String Address, String Address2,
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
            FillText(ap.Email, Email);
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
        }
        public void SignupInvalidMail(String Email){
            explicitWaitClickable(signInBtn);
            click(signInBtn);
            //Navigate to Authentication page
            AuthenticationPage ap = new AuthenticationPage(driver);
            explicitWaitVisibility(ap.createAccBox);
            FillText(ap.emailAddressField, Email);
            click(ap.CreateAccBtn);
        }
    }
