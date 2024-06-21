package Tests;

import Base.BaseTest;
import Pages.FooterPage;
import Pages.LogInPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Footer extends BaseTest {


    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        logInPage = new LogInPage(driver);
        footer = new FooterPage(driver);
        logInPage.logIn();
    }

    @Test
    public void FooterLinks(){
        String expectedTwitterUrl = "https://x.com/saucelabs";
        String expectedFacebookUrl = "https://www.facebook.com/saucelabs";
        String expectedLinkedinUrl = "https://www.linkedin.com/company/sauce-labs/";

        footer.clickOnFooterLinks();

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        //driver.getWindowHandles() ovde driver pokupi ID svakog taba i zatim ga smesti u listu



        Assert.assertEquals(driver.switchTo().window(listaTabova.get(0)).getCurrentUrl() ,"https://www.saucedemo.com/inventory.html");
        driver.close();
        Assert.assertEquals(driver.switchTo().window(listaTabova.get(2)).getCurrentUrl() ,expectedTwitterUrl);
        driver.close();
        Assert.assertEquals(driver.switchTo().window(listaTabova.get(1)).getCurrentUrl(), expectedFacebookUrl);
        driver.close();
        Assert.assertEquals(driver.switchTo().window(listaTabova.get(3)).getCurrentUrl(), expectedLinkedinUrl);
        driver.close();
    }

    @AfterMethod
    public void tearDown(){
      driver.quit();
        }
    }

