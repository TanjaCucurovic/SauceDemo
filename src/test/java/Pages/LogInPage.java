package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

    WebDriver driver;
    WebElement usernameInputFiled;
    WebElement passwordInputField;
    WebElement loginButton;
    WebElement burgerMenuButton;
    WebElement logOutSideBarButton;
    String validPassword = "secret_sauce";
    String validUsername = "standard_user";
    String invalidUsername = "secret";
    String invalidPassword = "password";

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameInputFiled() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordInputField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getBurgerMenuButton() {
        return driver.findElement(By.cssSelector(".bm-burger-button"));
    }

    public WebElement getLogOutSideBarButton() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }
    //---------------------------------------------------------

    public void usernameInput(){
        getUsernameInputFiled().clear();
        getUsernameInputFiled().sendKeys(validUsername);
    }

    public void passwordInput(){
        getPasswordInputField().clear();
        getPasswordInputField().sendKeys(validPassword);
    }
    public void clickOnLoginButton(){
        getLoginButton().click();
    }

    public void invalidUsernameInput(){
        getUsernameInputFiled().clear();
        getUsernameInputFiled().sendKeys(invalidUsername);
    }
    public void invalidPasswordInput(){
        getPasswordInputField().clear();
        getPasswordInputField().sendKeys(invalidPassword);
    }
    public void clickOnBurgerMenu(){
        getBurgerMenuButton().click();

    }
    public void clickOnLogOut(){
        getLogOutSideBarButton().click();
    }

    public void logIn(){
        usernameInput();
        passwordInput();
        clickOnLoginButton();
    }



}
