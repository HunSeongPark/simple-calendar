package com.hunseong.calendar.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Hunseong on 2022/06/09
 */
@NoArgsConstructor
@Getter
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;
    private LocalDateTime createdAt;

    public User(String name, String email, String password, LocalDate birthday, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.createdAt = createdAt;
    }
}
