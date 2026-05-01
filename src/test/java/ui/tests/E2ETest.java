package ui.tests;

import base.BaseUI;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.LoginPage;
import ui.pages.ProductsPage;
import org.testng.annotations.Listeners;


public class E2ETest extends BaseUI {
	
	

    @Test
    public void completeEndToEndFlow() {

        // LOGIN
        LoginPage login = new LoginPage(driver);

        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        // PRODUCT
        ProductsPage product = new ProductsPage(driver);

        product.addFirstProductToCart();
        product.openCart();

        // VALIDATION
        Assert.assertEquals(product.getCartCount(), "1");
    }
}