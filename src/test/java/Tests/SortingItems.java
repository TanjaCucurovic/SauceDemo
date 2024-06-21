package Tests;

import Base.BaseTest;
import Pages.LogInPage;
import Pages.SortItems;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortingItems extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        logInPage = new LogInPage(driver);
        sortItems = new SortItems(driver);
        logInPage.logIn();

    }
    @Test
    public void sortItemsByPriceLowToHigh(){
        sortItems.sortByPriceLowTOHigh();

        Assert.assertTrue(sortItems.sortingLowToHigh());
    }
    @Test
    public void sortItemsHighToLow(){
        sortItems.sortByPriceHighToLow();

        Assert.assertTrue(sortItems.sortingHighToLow());
    }



    @AfterMethod
    public void tearDown(){
        this.driver.quit();
    }
}
