package ru.levelup.qa.at.design.patterns.builder;

public class UserWithBuilder {

    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;

    private UserWithBuilder(String username, String email, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Override
    public String toString() {
        return "UserWithBuilder{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class UserBuilder {

        private String username;
        private String email;
        private String firstName;
        private String lastName;

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserWithBuilder.UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserWithBuilder build() {
            return new UserWithBuilder(this.username, this.email, this.firstName, this.lastName);
        }
    }
}
