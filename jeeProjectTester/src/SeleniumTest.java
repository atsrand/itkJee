
import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class SeleniumTest  {

    WebDriver driver = new FirefoxDriver();

    @Test
    public void seleniumTest() throws Exception {

        driver.get("http://localhost:8080/jeeProject/truncate_tables");

        addFirst("1");

        element("menuAdd").click();

        element("unit.name").sendKeys("b");
        element("unit.code").sendKeys("2");

        Select select = new Select(element("superiorCode"));
        select.selectByValue("1");

        element("saveForm").click();

        driver.quit();
    }

    private void addFirst(String code) {
        driver.get("http://localhost:8080/jeeProject/");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        element("menuAdd").click();

        element("unit.name").sendKeys("nimi");
        element("unit.code").sendKeys(code);

        element("addChannel").click();
        element("channels0.value").sendKeys("123");

        element("saveForm").click();
    }

    private WebElement element(String id) {
        return driver.findElement(By.id(id));
    }

    private void test1() {
      new WebDriverWait(driver, 10).until(
      new Predicate<WebDriver>() {

          @Override
          public boolean apply(WebDriver driver) {
              return ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").equals("complete");
          }
      });
    }



}
