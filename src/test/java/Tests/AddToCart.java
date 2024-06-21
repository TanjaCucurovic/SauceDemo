package Tests;

import Base.BaseTest;
import Pages.InventoryPage;
import Pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCart extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        logInPage = new LogInPage(driver);
        inventoryPage = new InventoryPage(driver);
        logInPage.logIn();


    }

    @Test(priority = 10)
    public void addingToCart() {
        inventoryPage.clickAddToCartButton();
        //Remove button is displayed
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed());
        //cart badge displayed
        Assert.assertTrue(driver.findElement(By.className("shopping_cart_badge")).isDisplayed());
    }

    @Test(priority = 20)
    public void removeItemFromCart() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        inventoryPage.clickAddToCartButton();
        inventoryPage.clickRemoveButton();

        Assert.assertEquals(this.driver.getCurrentUrl(), expectedUrl);

    }

    @Test(priority = 30)
    public void emptyCart() {
        inventoryPage.clickOnCartIcon();

        Assert.assertTrue(driver.findElement(By.id("continue-shopping")).isDisplayed());

    }
    @Test(priority = 40)
    public void addProducts(){
        inventoryPage.addProductsToCart();

        Assert.assertTrue(driver.findElement(By.id("continue-shopping")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-onesie")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("checkout")).isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        this.driver.quit();
    }
}
