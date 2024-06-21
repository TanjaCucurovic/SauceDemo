package Tests;

import Base.BaseTest;
import Pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogIn extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        logInPage = new LogInPage(driver);

    }
    @Test (priority =  10)
    public void userCanLogIn(){
        logInPage.usernameInput();
        logInPage.passwordInput();
        logInPage.clickOnLoginButton();

        //after login, user is redirected to inventory page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }
    @Test (priority = 20)
    public void userCannotLoginWithInvaidUsername(){
        logInPage.invalidUsernameInput();
        logInPage.passwordInput();
        logInPage.clickOnLoginButton();

        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message-container.error")).isDisplayed(),
                "Epic sadface: Username and password do not match any user in this service" );

    }
    @Test (priority = 30)
    public void userCannotLoginWithInvalidPassword(){
        logInPage.usernameInput();
        logInPage.invalidPasswordInput();
        logInPage.clickOnLoginButton();

        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message-container.error")).isDisplayed(),
                "Epic sadface: Username and password do not match any user in this service" );
    }
    @Test (priority = 40)
    public void userCanLogOut() throws InterruptedException {
        logInPage.usernameInput();
        logInPage.passwordInput();
        logInPage.clickOnLoginButton();
        logInPage.clickOnBurgerMenu();
        Thread.sleep(3000);
        logInPage.clickOnLogOut();

        //After clickOn logOut button user is redirected to Login page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
    @AfterMethod
    public void tearDown(){
        this.driver.quit();
    }


}
