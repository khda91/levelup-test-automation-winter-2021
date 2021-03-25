package ru.levelup.qa.at.design.patterns.builder;

import org.testng.annotations.Test;

import java.time.LocalDate;

public class UserWithLombokTest {

    @Test
    public void builderTest() {
        UserWithLombok user1 = UserWithLombok.builder()
                .username("uasername")
                .email("email@email.com")
                .firstName("email")
                .lastName("email")
                .build();

        System.out.println(user1);
        System.out.println();

        UserWithLombok user2 = UserWithLombok.builder()
                .email("email@email.com")
                .firstName("email")
                .build();

        System.out.println(user2);
        System.out.println();

        UserWithLombok user3 = UserWithLombok.builder()
                .username("uasername")
                .lastName("email")
                .dateOfBirth(LocalDate.of(2000, 2, 29))
                .build();

        System.out.println(user3);
        System.out.println();

        System.out.println("User 3 username -> " + user3.getUsername());
        System.out.println("User 3 date of birth -> " + user3.getDateOfBirth());

    }
}
