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

}
