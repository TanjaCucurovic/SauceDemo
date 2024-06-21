package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartForm extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        cartPage = new CartPage(driver);
        logInPage = new LogInPage(driver);
        inventoryPage = new InventoryPage(driver);
        logInPage.logIn();
        inventoryPage.addingProductToCart();

    }
    @Test
    public void fillCheckoutForm(){
        cartPage.clickOnChechoutButton();
        cartPage.checkoutInformation();

        Assert.assertTrue(driver.findElement(By.id("back-to-products")).isDisplayed());

    }
    @Test
    public void emptyCheckoutform(){
        cartPage.clickOnChechoutButton();
        cartPage.getContinueButton().click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message-container.error")).isDisplayed(),
                "Error: First Name is required");
    }
    @AfterMethod
    public void tearDown(){
        this.driver.quit();
    }

}