package ru.levelup.qa.at.java.exceptions;

public class MyCustomException extends RuntimeException {

    public MyCustomException(String message) {
        super(message);
    }

    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
