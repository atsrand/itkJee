package main;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class BatchRunner {

    public static void main(String[] args) {
        new BatchRunner().run();
    }

    private void run() {
        List<Student> students = getStudents(readStudentFile());

        runTests(students);
    }

    private void runTests(List<Student> students) {
        for (Student student : students) {

            JUnitCore junit = new JUnitCore();
            junit.addListener(new RunListener() {
                @Override
                public void testFailure(Failure failure) throws Exception {
                    System.out.println(failure);
                }
            });

            System.out.println(student);
            System.setProperty("userName", student.userName);
            junit.run(ExampleTest.class);
        }
    }

    private List<Student> getStudents(String fileContents) {
        List<Student> students = new ArrayList<>();

        for (String line : fileContents.split("\n")) {
            String[] pair = line.split("\\|");
            students.add(new Student(pair[0], pair[1]));
        }

        return students;
    }

    private String readStudentFile() {
        String file = ClassLoader.getSystemClassLoader()
                .getResource("users.txt").getFile();
        String contents = util.Util.readFileUTF8(new File(file));
        return contents;
    }

}

class Student {
    final String userName;
    final String name;
    public Student(String userName, String name) {
        this.userName = userName;
        this.name = name;
    }
    @Override
    public String toString() {
        return MessageFormat.format("{0} ({1})", name, userName);
    }
}