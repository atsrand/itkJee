package main;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ExampleTest {

    String userName = System.getProperty("userName");

    @Test
    public void test1() {
        fail("a failure for " + userName);
    }

    @Test
    public void test2() {

    }


}
