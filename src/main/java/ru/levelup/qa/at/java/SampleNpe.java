package ru.levelup.qa.at.java;

public class SampleNpe {

    private String field;

    public void setField(String field) {
        if (field == null) {
            throw new NullPointerException();
        }
        this.field = field;
    }
}
