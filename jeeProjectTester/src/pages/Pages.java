package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pages {

    private static WebDriver driver;

    protected static WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void close() {
        getDriver().close();
    }

    protected WebElement element(String id) {
        return getDriver().findElement(By.id(id));
    }

    public String getPageSource() {
        return getDriver().getPageSource();
    }

    public static void truncateTables() {
        getDriver().get("http://localhost:8080/jeeProject/truncate_tables");
    }

}
