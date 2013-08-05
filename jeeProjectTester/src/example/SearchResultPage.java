package example;

import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;

//        (new WebDriverWait(driver, 1)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().startsWith("Otsingutulemused");
//            }
//        });
    }

    public String getTitle() {
        return driver.getTitle();
    }


}
