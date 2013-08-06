package tests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.FormPage;
import pages.HomePage;
import pages.Pages;

@RunWith(JUnitParamsRunner.class)
public class TreeTest  {

    @Test
    @Parameters({"1,", "2,1"})
    public void addTree(String code, String superiorCode) {

        FormPage formPage = new HomePage().menu().clickAdd();

        formPage.setName(code);
        formPage.setCode(code);
        formPage.setSuperiorCode(superiorCode);

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
