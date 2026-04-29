package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");

    public void addFirstProductToCart() {
        driver.findElement(addToCart).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public boolean isCartBadgeVisible() {
        return driver.findElements(cartBadge).size() > 0;
    }
}