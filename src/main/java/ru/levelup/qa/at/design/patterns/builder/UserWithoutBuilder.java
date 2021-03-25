package ru.levelup.qa.at.design.patterns.builder;

public class UserWithoutBuilder {

    private String username;
    private String email;
    private String firstName;
    private String lastName;

    public UserWithoutBuilder() {
    }

    public UserWithoutBuilder(String username) {
        this.username = username;
    }

    public UserWithoutBuilder(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserWithoutBuilder(String username, String email, String firstName) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
    }

    public UserWithoutBuilder(String username, String email, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
