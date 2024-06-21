package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FooterPage {

    WebDriver diver;
    List<WebElement> socialLinks;


    public FooterPage(WebDriver diver) {
        this.diver = diver;
    }
    public List<WebElement> getSocialLinks() {
        return diver.findElements(By.cssSelector("ul.social>li"));
    }

    //cssSelector vraca sve li elemente, koji se nalaze unutar parent ul elementa sa klasom social

    //--------------------------------------------------------

    public void clickOnFooterLinks(){
        for (WebElement link:getSocialLinks()){
                link.click();

        }
    }


}
