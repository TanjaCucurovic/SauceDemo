package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BurgerPage {

    WebDriver driver;
    WebElement burgerMenu;
    WebElement aboutLink;
    WebElement crossButton;


    public BurgerPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBurgerMenu() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getAboutLink() {
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public WebElement getCrossButton() {
        return driver.findElement(By.cssSelector(".bm-cross-button"));
    }
    //--------------------------------------------------------------

    public void clickOnAboutSideBarLink() throws InterruptedException {
        getBurgerMenu().click();
        Thread.sleep(3000);
        getAboutLink().click();
    }
    public void clickOnCrossButton() throws InterruptedException {
        getBurgerMenu().click();
        Thread.sleep(3000);
        getCrossButton().click();

    }



}
