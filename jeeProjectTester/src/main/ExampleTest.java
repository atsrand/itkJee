package main;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ExampleTest {

    @Test
    public void test1() {
        String userName = System.getProperty("userName");
        fail("a failure for " + userName);
    }

    @Test
    public void test2() {

    }


}
