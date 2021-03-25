package ru.levelup.qa.at.design.patterns.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@ToString
public class UserWithLombok {

    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
}
