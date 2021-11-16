package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TShirtsPage extends WomenPage {
    public TShirtsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css="#uniform-layered_id_attribute_group_1")
    private WebElement sizeS;
    @FindBy (css="#uniform-layered_id_attribute_group_2")
    private WebElement sizeM;
    @FindBy (css="#uniform-layered_id_attribute_group_3")
    private WebElement sizeL;
    @FindBy (css = "#layered_id_attribute_group_13")
    private WebElement colorOrange;
    @FindBy (css = "#layered_id_attribute_group_14")
    private WebElement colorBlue;
    @FindBy (css = ".product_list.grid.row .button.ajax_add_to_cart_button>span")
    private WebElement addToCartBtn;
    @FindBy (css =".btn[title='Proceed to checkout']")
    private WebElement proceedToCheckOutBtn;

    public WebElement getProceedToCheckOutBtn() {
        return proceedToCheckOutBtn;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public void ChooseSize(String sizeLetter){
        switch (sizeLetter){
            case "S":
                click(sizeS);
                break;
            case "M":
                click(sizeM);
                break;
            case "L":
                click(sizeL);
        }
    }

    public void ChooseColor(String colorName){
        switch (colorName){
            case "Orange":
                click(colorOrange);
                break;
            case "Blue":
                click(colorBlue);
                break;
        }
    }

}
