package ru.levelup.qa.at.java.exceptions;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BasicExceptionExample {

    public static void main(String[] args) throws IOException {
        printStringToFile("Some print String");
        printStringToFileTryWithResources("saasasasa");
        printStringToFile("hsh/hhhy.txt", "Some print String");
    }

    static void printStringToFile(String printString) {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter("out.txt"));
            for (int i = 0; i < 100; i++) {
                out.println(printString);
            }
        } catch (IOException e) {
            System.out.println("IOException caught");
//            log.error("some message", e) - более предпочтительный вариант чем печатание стэк трейса
//            e.printStackTrace();
            throw new MyCustomException("MSG", e);
        } finally {
            System.out.println("Finally");
            if (out != null) {
                out.close();
            }
        }
    }

    static void printStringToFileTryWithResources(String printString) {
        try (PrintWriter out = new PrintWriter(new FileWriter("sdsdvs/out.txt"))) {
//        try (PrintWriter out = new PrintWriter(new FileWriter("out1.txt"))) {
            for (int i = 0; i < 100; i++) {
                out.println(printString);
            }
//        } catch (FileNotFoundException e) {
//            System.out.println("IOException caught");
////            log.error("some message", e) - более предпочтительный вариант чем печатание стэк трейса
////            e.printStackTrace();
//            throw new MyCustomException("MSG", e);
//        }
        } catch (IOException e) {
            e.printStackTrace();
//            log.error("Error appears", e);
        }
    }

    static void printStringToFile(String fileName, String printString) throws IOException {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < 100; i++) {
                out.println(printString);
            }
        } finally {
            System.out.println("Finally");
            if (out != null) {
                out.close();
            }
        }
    }

    public static void printStringToFileWithException(String printString) throws IOException {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter("out.txt"));
            System.out.println(printString.length());
            for (int i = 0; i < 100; i++) {
                out.println(printString);
            }
        } finally {
            System.out.println("Finally");
            if (out != null) {
                out.close();
            }
        }
    }

}
