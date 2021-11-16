package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class ShoppingCart extends BaseTest {

    final String expectedOrderCompleteMSG = "Your order on My Store is complete.";
    final String expectedDressesCategory = "Dresses";

    @Test(description = "Choose product from list")
    @Description("Choose product from list")
    @Severity(SeverityLevel.CRITICAL)
    public void chooseProduct(){
        var homePage = new HomePage(driver);
        homePage.ClickWomenCat();
        WomenPage womenCategory = new WomenPage(driver);
        womenCategory.chooseItem(0);
        //click proceed to checkout POP UP
        homePage.click(womenCategory.getProceedToCheckoutBtn());
    }
    @Test(description = "Buy a T-Shirt")
    @Description("Buy a T-Shirt")
    @Severity(SeverityLevel.CRITICAL)
    public void BuyTShirt(){
        var scs = new ShoppingCartSummaryPage(driver);
        //summary proceed to checkout
        scs.click(scs.getSpProceedToCheckOutSummaryBtn());
        //Address proceed to checkout
        scs.click(scs.getSpProceedToCheckOutAddress());
        // agree to terms and services
        scs.click(scs.getTermsOfSerivceCheckBox());
        //shipping proceed to checkout
        scs.click(scs.getSpProceedToCheckOutCarrierBtn());
        //Choose payment method
        scs.choosePaymentMethod("Bank");
        //confirm order
        scs.click(scs.getConfirmOrderBtn());
        var confirmationText = scs.readTextBox();
        Assert.assertEquals(confirmationText,expectedOrderCompleteMSG);
    }

    @Test(description = "Select color")
    @Description("Select color")
    @Severity(SeverityLevel.MINOR)
    public void colorSelection(){
        var homePage = new HomePage(driver);
        homePage.ClickWomenCat();
        var womenPage = new WomenPage(driver);
        homePage.click(womenPage.getDresses());
        String categoryName = checkCategory();
        Assert.assertEquals(categoryName,expectedDressesCategory);
    }

}
