package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage extends Pages {

    public HomePage() {
        getDriver().get("http://localhost:8080/jeeProject/");
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public void selectAdd() {
        // TODO Auto-generated method stub

    }

    public Menu menu() {
        return new Menu();
    }

}
