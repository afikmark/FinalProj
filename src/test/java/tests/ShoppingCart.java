package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class ShoppingCart extends Login {

    final String expectedOrderCompleteMSG = "Your order on My Store is complete.";

    @Test
    public void validSignIN(){
        HomePage hp = new HomePage(driver);
        hp.navToSignIn();
        AuthenticationPage ap = new AuthenticationPage(driver);
        ap.SignIn(validEmail, validPassword);
    }
    @Test
    public void chooseProduct(){
        HomePage hp = new HomePage(driver);
        hp.ClickWomenCat();
        Women womenCategory = new Women(driver);
        womenCategory.chooseItem(0);
        BasePage bp = new BasePage(driver);
        //click proceed to checkout POP UP
        bp.Click(womenCategory.getProceedToCheckoutBtn());
    }
    @Test
    public void BuyTShirt(){
        BasePage bp = new BasePage(driver);
        ShoppingCartSummary scs = new ShoppingCartSummary(driver);
        //summary proceed to checkout
        bp.Click(scs.getSpProceedToCheckOutSummaryBtn());
        //Address proceed to checkout
        bp.Click(scs.getSpProceedToCheckOutAddress());
        // agree to terms and services
        bp.Click(scs.getTermsOfSerivceCheckBox());
        //shipping proceed to checkout
        bp.Click(scs.getSpProceedToCheckOutCarrierBtn());
        //Choose payment method
        scs.choosePaymentMethod("Bank");
        //confirm order
        bp.Click(scs.getConfirmOrderBtn());
        String confirmationText = scs.readTextBox();
        Assert.assertEquals(confirmationText,expectedOrderCompleteMSG);
    }

    @Test
    public void colorSelection(){
        HomePage hp = new HomePage(driver);
        hp.ClickWomenCat();

    }

}
