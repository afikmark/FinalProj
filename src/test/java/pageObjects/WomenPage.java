package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WomenPage extends HomePage{
    public WomenPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".subcategory-image  [title='Tops']")
    private WebElement tops;
    @FindBy(css=".subcategory-image  [title='T-shirts']")
    private WebElement tshirts;
    @FindBy(css = ".product_list.grid.row >li")
    private List<WebElement>itemsList;
//    @FindBy (css="#add_to_cart")
//    private WebElement addToCartBtn;
    @FindBy (css=".block_content >ul>li.last>a")
    private WebElement Dresses;
    @FindBy (css=".btn[title='Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;
    @FindBy (css =".button-container [title='Add to cart']")
    private List<WebElement> addToCartBtnList;
    @FindBy (css="#ul_layered_id_attribute_group_3 li")
    private List<WebElement> chooseColorList;

    public void clickTops(){
        Click(tops);
    }
    public void clickTshirts(){
        Click(tshirts);
    }

    public WebElement getTops() {
        return tops;
    }

    public WebElement getTshirts() {
        return tshirts;
    }

    public List<WebElement> getItemsList() {
        return itemsList;
    }

    public WebElement getDresses() {
        return Dresses;
    }

    public List<WebElement> getAddToCartBtnList() {
        return addToCartBtnList;
    }

    public List<WebElement> getChooseColorList() {
        return chooseColorList;
    }

    //    public WebElement getAddToCartBtn() {
//        return addToCartBtn;
//    }
public WebElement getProceedToCheckoutBtn() {
    return proceedToCheckoutBtn;
}

    public List<String> getItemNameList(){
        List<WebElement> itemList = itemsList;
        ArrayList<String> itemNames = new ArrayList<String>();
        for (WebElement item:itemList) {
            itemNames.add(item.getText());
        }
        return itemNames;
    }

    public void chooseItem(int itemNameListIndex){
        //products list
        List<WebElement> itemList = itemsList;
        //container of all add to cart buttons
        List<WebElement> addToCartButtons = addToCartBtnList;
        //list of item names
        List<String> itemNames= getItemNameList();
        for (WebElement item:itemList) {
            String itemName = item.getText();
            String itemNameFromList = itemNames.get(itemNameListIndex);
            if(itemName.contains(itemNameFromList)){
                MoveToElement(item);
                for(int i=0;i<addToCartButtons.size();i++){
                    WebElement addToCartButton = addToCartButtons.get(itemNameListIndex);
                    Click(addToCartButton);
                    break;
                }
                break;
            }
        }
    }


}
