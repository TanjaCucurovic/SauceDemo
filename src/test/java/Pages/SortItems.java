package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SortItems {

    WebDriver driver;
    WebElement sortButtonLowToHigh;
    WebElement sortButtonHighToLow;
    List<WebElement> cards;
    List<Double> prices = new ArrayList<>();

    public SortItems(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCards() {
        return driver.findElements(By.className("inventory_item_price"));
    }

    public WebElement getSortButtonLowToHigh() {
        return driver.findElement(By.cssSelector("option[value='lohi']"));
    }

    public WebElement getSortButtonHighToLow() {
        return driver.findElement(By.cssSelector("option[value='hilo']"));
    }

    //----------------------------------------------------

    public boolean sortingLowToHigh() {
        boolean sorted = true;
        for (WebElement card : getCards()) {
            String priceText = card.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                sorted = false;
            }
        }
    return sorted;
    }
    public boolean sortingHighToLow() {
        boolean sorted = true;
        for (WebElement card : getCards()) {
            String priceText = card.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                sorted = false;
            }
        }
        return sorted;
    }

    public void sortByPriceLowTOHigh(){
        getSortButtonLowToHigh().click();
    }

    public void sortByPriceHighToLow(){
        getSortButtonHighToLow().click();
    }

}
