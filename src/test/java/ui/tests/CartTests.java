package ui.tests;

import base.BaseUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pages.LoginPage;
import ui.pages.ProductsPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class CartTests extends BaseUI {

    @Test
    public void addToCartTest() {

    	LoginPage login = new LoginPage(BaseUI.getDriver());

        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        ProductsPage product = new ProductsPage(BaseUI.getDriver());

        product.addFirstProductToCart();

        Assert.assertEquals(product.getCartCount(), "1");
    }

    @Test
    public void cartEmptyTest() {

    	LoginPage login = new LoginPage(BaseUI.getDriver());

        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        ProductsPage product = new ProductsPage(BaseUI.getDriver());

        product.openCart();

        Assert.assertTrue(
        		BaseUI.getDriver().findElements(By.className("shopping_cart_badge")).size() == 0
        );
    }
}