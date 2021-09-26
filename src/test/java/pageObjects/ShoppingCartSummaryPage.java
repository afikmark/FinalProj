package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends HomePage {
    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart_navigation .btn[title='Proceed to checkout']")
    private WebElement spProceedToCheckOutSummaryBtn;
    @FindBy(css = "[name='processAddress']")
    private WebElement spProceedToCheckOutAddress;
    @FindBy(css = "[name='processCarrier']")
    private WebElement spProceedToCheckOutCarrierBtn;


    @FindBy(css = "#uniform-cgv")
    private WebElement termsOfSerivceCheckBox;
    @FindBy(css = "#HOOK_PAYMENT .bankwire")
    private WebElement payByBankWire;
    @FindBy(css = "#HOOK_PAYMENT .cheque")
    private WebElement payByCheck;
    @FindBy(css = ".button.btn.btn-default.button-medium[type='submit']")
    private WebElement confirmOrderBtn;
    @FindBy(css = ".cheque-indent")
    private WebElement confirmationTXT;

    public WebElement getConfirmOrderBtn() {
        return confirmOrderBtn;
    }

    public WebElement getTermsOfSerivceCheckBox() {
        return termsOfSerivceCheckBox;
    }

    public WebElement getSpProceedToCheckOutSummaryBtn() {
        return spProceedToCheckOutSummaryBtn;
    }

    public WebElement getSpProceedToCheckOutAddress() {
        return spProceedToCheckOutAddress;
    }

    public WebElement getSpProceedToCheckOutCarrierBtn() {
        return spProceedToCheckOutCarrierBtn;
    }

    public void choosePaymentMethod(String payment) {
        switch (payment) {
            case "Bank":
                Click(payByBankWire);
                break;
            case "Check":
                Click(payByCheck);
        }
    }

    public String readTextBox() {
        return confirmationTXT.getText();
    }
}
