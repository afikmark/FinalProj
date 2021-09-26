package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class ShoppingCart extends Login {

    final String expectedOrderCompleteMSG = "Your order on My Store is complete.";

    @Test(description = "Sign in")
    @Description("Sign in")
    @Severity(SeverityLevel.CRITICAL)
    public void validSignIN(){
        HomePage hp = new HomePage(driver);
        hp.navToSignIn();
        AuthenticationPage ap = new AuthenticationPage(driver);
        ap.SignIn(validEmail, validPassword);
    }
    @Test(description = "Choose product from list")
    @Description("Choose product from list")
    @Severity(SeverityLevel.CRITICAL)
    public void chooseProduct(){
        HomePage hp = new HomePage(driver);
        hp.ClickWomenCat();
        WomenPage womenCategory = new WomenPage(driver);
        womenCategory.chooseItem(0);
        //click proceed to checkout POP UP
        hp.Click(womenCategory.getProceedToCheckoutBtn());
    }
    @Test(description = "Buy a T-Shirt")
    @Description("Buy a T-Shirt")
    @Severity(SeverityLevel.CRITICAL)
    public void BuyTShirt(){
        ShoppingCartSummaryPage scs = new ShoppingCartSummaryPage(driver);
        //summary proceed to checkout
        scs.Click(scs.getSpProceedToCheckOutSummaryBtn());
        //Address proceed to checkout
        scs.Click(scs.getSpProceedToCheckOutAddress());
        // agree to terms and services
        scs.Click(scs.getTermsOfSerivceCheckBox());
        //shipping proceed to checkout
        scs.Click(scs.getSpProceedToCheckOutCarrierBtn());
        //Choose payment method
        scs.choosePaymentMethod("Bank");
        //confirm order
        scs.Click(scs.getConfirmOrderBtn());
        String confirmationText = scs.readTextBox();
        Assert.assertEquals(confirmationText,expectedOrderCompleteMSG);
    }

    @Test(description = "Select color")
    @Description("Select color")
    @Severity(SeverityLevel.MINOR)
    public void colorSelection(){
        HomePage hp = new HomePage(driver);
        hp.ClickWomenCat();

    }

}
