package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //Elements
    @FindBy(css = ".login")
    private  WebElement signInBtn;
    @FindBy(css = ".row .logout")
    private WebElement signOutBtn;
    @FindBy (css = "#block_top_menu > ul > li:nth-child(1) > a")
    private WebElement womenCategory;
    @FindBy (css= "#block_top_menu .submenu-container ul >li [title='T-shirts']")
    private  WebElement womenTshirts;
    @FindBy (css=".category-name")
   private WebElement categoryName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public WebElement getSignOutBtn() {
        return signOutBtn;
    }

    public WebElement getWomenCategory() {
        return womenCategory;
    }

    public WebElement getWomenTshirts() {
        return womenTshirts;
    }

    public WebElement getCategoryName() {
        return categoryName;
    }


    @Step("Navigate to sign in page {0}")
    public void navToSignIn(){
        click(signInBtn);
    }
    @Step("Click on signout button {1}")
    public void signOut(){
        click(signOutBtn);
    }
    @Step("Click on WomenPage category {2}")
    public void ClickWomenCat(){
        click(womenCategory);
    }


}





