package example;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PageObjectTest  {

    WebDriver driver = new FirefoxDriver();

    @Test
    public void pageObjectTest() throws Exception {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        long start = System.currentTimeMillis();
        elapsed(start);

        HomePage1 homePage = new HomePage1(driver);

        elapsed(start);

        assertThat(homePage.getTitle(), is("IT Kolledž"));

        elapsed(start);

        SearchResultPage resultPage = homePage.search("kontakt");

        elapsed(start);

        assertThat(resultPage.getTitle(), is("Otsingutulemused terminile: \"kontakt\""));

        elapsed(start);
    }

    private void elapsed(long start) {
        System.out.println(System.currentTimeMillis() - start);
    }

    @After
    public void quit() {
        driver.quit();
    }

}
