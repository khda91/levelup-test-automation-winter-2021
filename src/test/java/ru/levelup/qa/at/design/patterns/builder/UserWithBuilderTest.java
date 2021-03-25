package ru.levelup.qa.at.design.patterns.builder;

import org.testng.annotations.Test;

public class UserWithBuilderTest {

    @Test
    public void builderTest() {
        UserWithBuilder user1 = UserWithBuilder.builder()
                .username("uasername")
                .email("email@email.com")
                .firstName("email")
                .lastName("email")
                .build();

        System.out.println(user1);
        System.out.println();

        UserWithBuilder user2 = UserWithBuilder.builder()
                .email("email@email.com")
                .firstName("email")
                .build();

        System.out.println(user2);
        System.out.println();

        UserWithBuilder user3 = UserWithBuilder.builder()
                .username("uasername")
                .lastName("email")
                .build();

        System.out.println(user3);
        System.out.println();

        System.out.println("User 3 username -> " + user3.getUsername());
    }
}
