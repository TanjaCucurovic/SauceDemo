package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    WebDriver driver;
    WebElement addToCartButton;
    WebElement addToCartBikeLight;
    WebElement addToCartOnesie;
    WebElement removeButton;
    WebElement cartIcon;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getAddToCartBikeLight() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
    }

    public WebElement getAddToCartOnesie() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public WebElement getCartIcon() {
        return driver.findElement(By.id("shopping_cart_container"));
    }
    //-------------------------------------------------------------------

    public void clickAddToCartButton(){
        getAddToCartButton().click();
    }
    public void clickRemoveButton(){
        getRemoveButton().click();
    }
    public void clickOnCartIcon(){
        getCartIcon().click();
    }

    public void addingProductToCart(){
        clickAddToCartButton();
        clickOnCartIcon();
    }
    public void addProductsToCart(){
        getAddToCartButton().click();
        getAddToCartBikeLight().click();
        getAddToCartOnesie().click();
        clickOnCartIcon();
    }
}
