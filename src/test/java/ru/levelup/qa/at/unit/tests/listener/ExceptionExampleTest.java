package ru.levelup.qa.at.unit.tests.listener;

import org.testng.annotations.Test;
import ru.levelup.qa.at.java.exceptions.BasicExceptionExample;

import java.io.IOException;

public class ExceptionExampleTest {

    @Test
    public void testName() {
        try {
            BasicExceptionExample.printStringToFileWithException("sadvscas");
        } catch (IOException e) {
            System.out.println("Exception in TEST");
            e.printStackTrace();
        }

        try {
            BasicExceptionExample.printStringToFileWithException(null);
        } catch (IOException e) {
            System.out.println("IOException in TEST");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception in TEST");
            e.printStackTrace();
        }
    }
}
