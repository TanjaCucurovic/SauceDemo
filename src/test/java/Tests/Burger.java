package Tests;

import Base.BaseTest;
import Pages.BurgerPage;
import Pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Burger extends BaseTest {

    @BeforeMethod
    public void setUpPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        logInPage = new LogInPage(driver);
        burgerMenuPage = new BurgerPage(driver);
        logInPage.logIn();
    }
    @Test
    public void aboutLink() throws InterruptedException {
        String expectedUrl = "https://saucelabs.com/";
        burgerMenuPage.clickOnAboutSideBarLink();

        Assert.assertEquals(this.driver.getCurrentUrl(), expectedUrl);
    }
    @Test
    public void crossButtonFromBurger() throws InterruptedException {
        burgerMenuPage.clickOnCrossButton();

        //After clicking cross button on side bar, side bar is closed
       Assert.assertTrue(driver.findElement(By.cssSelector("div[aria-hidden='true']")).isDisplayed());
    }
   @AfterMethod
    public void tearDown(){
        this.driver.quit();
    }
}
