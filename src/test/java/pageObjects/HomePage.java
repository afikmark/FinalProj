package pageObjects;

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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navToSignIn(){
        Click(signInBtn);
    }
    public void signOut(){
        Click(signOutBtn);
    }

    public void HoverWomen(){
        MoveToElement(womenCategory);
    }

    public void ClickWomenCat(){
        Click(womenCategory);
    }


}





