package tests;

import junitparams.*;

import org.junit.*;
import org.junit.runner.RunWith;

import pages.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TreeTest  {

    @Test
    public void treePage() {

        TreePage treePage = new HomePage().menu().clickTree();

        String expected = "1\n" +
                          "   2";

        assertThat(treePage.getContents(), is(expected));
    }

    @Before
    public void setUp() {
        Pages.truncateTables();

        addUnit("1", "");
        addUnit("2", "1");
    }

    private void addUnit(String code, String superiorCode) {
        FormPage formPage = new HomePage().menu().clickAdd();

        formPage.setName(code);
        formPage.setCode(code);
        formPage.setSuperiorCode(superiorCode);

        formPage.save();
    }

    @After
    public void tearDown() {
        Pages.close();
    }
}
