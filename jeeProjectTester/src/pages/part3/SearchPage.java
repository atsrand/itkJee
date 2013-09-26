package pages.part3;

import org.openqa.selenium.WebDriver;

public class SearchPage extends Pages {

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage goTo() {
        goTo("Search");
        return new SearchPage(driver);
    }

    public void delete(String id) {
        element(id).click();
    }

    public SearchPage search(String searchString) {
        element("searchStringBox").sendKeys(searchString);
        element("filterButton").click();
        return new SearchPage(driver);
    }
}
