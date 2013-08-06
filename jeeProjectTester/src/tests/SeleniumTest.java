package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.FormPage;
import pages.HomePage;
import pages.Pages;

public class SeleniumTest  {

    @Test
    public void addUnit(String code, String parentCode) {

        FormPage formPage = new HomePage().menu().clickAdd();

        formPage.setName("1");
        formPage.setCode("1");
        formPage.addPhone("123");

        formPage.save();
    }

    @Test
    public void addTree() {

        FormPage formPage = new HomePage().menu().clickAdd();

        formPage.setName("1");
        formPage.setCode("1");
        formPage.addPhone("123");

        formPage.save();
    }

    @Before
    public void setUp() {
        Pages.truncateTables();
    }

    @After
    public void tearDown() {
        Pages.close();
    }

//    WebDriver driver = new FirefoxDriver();
//    WebDriver driver;
//
//    @Test
//    public void seleniumTest() throws Exception {
//
//        driver.get("http://localhost:8080/jeeProject/truncate_tables");
//
//        addFirst("1");
//
//        element("menuAdd").click();
//
//        element("unit.name").sendKeys("b");
//        element("unit.code").sendKeys("2");
//
//        Select select = new Select(element("superiorCode"));
//        select.selectByValue("1");
//
//        element("saveForm").click();
//
//        driver.quit();
//    }
//
//    private void addFirst(String code) {
//        driver.get("http://localhost:8080/jeeProject/");
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//
//        element("menuAdd").click();
//
//        element("unit.name").sendKeys("nimi");
//        element("unit.code").sendKeys(code);
//
//        element("addChannel").click();
//        element("channels0.value").sendKeys("123");
//
//        element("saveForm").click();
//    }
//
//    private WebElement element(String id) {
//        return driver.findElement(By.id(id));
//    }
//
//    private void test1() {
//      new WebDriverWait(driver, 10).until(
//      new Predicate<WebDriver>() {
//
//          @Override
//          public boolean apply(WebDriver driver) {
//              return ((JavascriptExecutor) driver)
//                    .executeScript("return document.readyState").equals("complete");
//          }
//      });
//    }
//


}
