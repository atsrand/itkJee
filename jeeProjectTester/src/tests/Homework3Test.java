package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import pages.part3.*;

public class Homework3Test  {

    // redirect after insert

    @Test
    public void searchPageExists() {
        Pages.goToSearchPage().assertElementPresent("listTable");
    }

    @Test
    public void addPageExists() {
        Pages.goToAddPage().assertElementPresent("formTable");
    }

    @Test
    public void searchPageHasValidMenu() {
        Pages.goToSearchPage().menu().isValid();
    }

    @Test
    public void addPageHasValidMenu() {
        Pages.goToAddPage().menu().isValid();
    }

    @Test
    public void unitsCanBeAdded() {
        String testCode = String.valueOf(System.nanoTime());

        SearchPage searchPage = Pages.goToAddPage().
                insert("testName", testCode);

        searchPage.assertElementPresent("row_" + testCode);
    }

    @Test
    public void allDataCanBeDeleted() {
        SearchPage searchPage = Pages.goToSearchPage().menu().clearData();
        assertThat(searchPage.getIdsStartingWith("row_"), is(empty()));
    }

    @Test
    public void sampleDataCanBeInserted() {
        SearchPage searchPage = Pages.goToSearchPage().menu().clearData();
        searchPage.menu().insertSampleData();

        assertThat(searchPage.getIdsStartingWith("row_"),
                contains("row_1", "row_1-1", "row_1-1-1",
                         "row_1-1-2", "row_1-2", "row_2"));
    }

    @Test
    public void unitsCanBeDeleted() {
        SearchPage searchPage = Pages.goToSearchPage().menu().clearData();
        long nanoTime = System.nanoTime();
        String testCode1 = String.valueOf(nanoTime++);
        String testCode2 = String.valueOf(nanoTime++);

        searchPage = Pages.goToAddPage().insert("testName", testCode1);
        searchPage = Pages.goToAddPage().insert("testName", testCode2);
        searchPage.delete("delete_" + testCode1);

        searchPage.assertElementNotPresent("row_" + testCode1);
        searchPage.assertElementPresent("row_" + testCode2);
    }

    @Test
    public void listCanBeFiltered() {
        Pages.goToSearchPage().menu().clearData();
        Pages.goToSearchPage().menu().insertSampleData();

        SearchPage searchPage = Pages.goToSearchPage();
        searchPage = searchPage.search("c");

        assertThat(searchPage.getIdsStartingWith("row_"),
                contains("row_1", "row_1-1-2", "row_1-2"));
    }
}
