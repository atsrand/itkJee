package pages.part3;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class Menu extends Pages {

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    public void isValid() {
        assertThat(getIdsStartingWith("menu_"), contains(
                "menu_Search", "menu_Add", "menu_ClearData", "menu_InsertData"));
    }

    public SearchPage clearData() {
        element("menu_ClearData").click();
        return new SearchPage(driver);
    }

    public SearchPage insertSampleData() {
        element("menu_InsertData").click();
        return new SearchPage(driver);
    }

}
