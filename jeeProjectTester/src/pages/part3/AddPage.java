package pages.part3;

import org.openqa.selenium.WebDriver;

public class AddPage extends Pages {

    public AddPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddPage goTo() {
        goTo("Add");
        return new AddPage(driver);
    }

    public SearchPage insert(String name, String code) {
        element("nameBox").sendKeys(name);
        element("codeBox").sendKeys(code);
        element("addButton").click();
        return new SearchPage(driver);
    }

}
