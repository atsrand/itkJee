package main;

import junitparams.*;

import org.junit.Test;
import org.junit.runner.*;
import org.junit.runner.notification.*;

@RunWith(JUnitParamsRunner.class)
public class BatchRunner {

    @Test
    @FileParameters(value = "classpath:users.csv")
    public void runAllTests(String userName, String name) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new RunListener() {
            @Override
            public void testFailure(Failure failure) throws Exception {
                System.out.println(failure);
            }
        });

        System.out.println(name);

        System.setProperty("userName", userName);
        junit.run(ExampleTest.class);
    }
}