package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage1 {

    private WebDriver driver;

    public HomePage1(WebDriver driver) {
        this.driver = driver;
        driver.get("http://www.itcollege.ee/");
    }

    public SearchResultPage search(String searchString) {

        WebElement element = driver.findElement(By.id("pageMaiSearchFromBox"));

        element.sendKeys("kontakt");

        element.submit();

        return new SearchResultPage(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
