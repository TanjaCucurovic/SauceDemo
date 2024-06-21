package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;
    WebElement shoppingbutton;
    WebElement checkoutButton;
    WebElement firstname;
    WebElement lastname;
    WebElement postalCode;
    WebElement continueButton;
    WebElement finishButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getShoppingbutton() {
        return driver.findElement(By.id("continue-shopping"));
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.id("checkout"));
    }

    public WebElement getFirstname() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastname() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getPostalCode() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.id("finish"));
    }
    //-------------------------------------------------------------


    public void clickOnContinueShoppingButton(){
        getShoppingbutton().click();
    }
    public void clickOnChechoutButton(){
        getCheckoutButton().click();
    }
    public void checkoutInformation(){
        getFirstname().clear();
        getFirstname().sendKeys("Tanja");
        getLastname().clear();
        getLastname().sendKeys("cucurovic");
        getPostalCode().clear();
        getPostalCode().sendKeys("/");
        getContinueButton().click();
        getFinishButton().click();
    }


}
