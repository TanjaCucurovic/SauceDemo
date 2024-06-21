package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public LogInPage logInPage;
    public InventoryPage inventoryPage;
    public SortItems sortItems;
    public CartPage cartPage;
    public BurgerPage burgerMenuPage;
    public FooterPage footer;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }


}
