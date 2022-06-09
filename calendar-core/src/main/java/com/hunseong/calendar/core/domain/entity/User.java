package com.hunseong.calendar.core.domain.entity;

import com.hunseong.calendar.core.util.Encryptor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Hunseong on 2022/06/09
 */
@NoArgsConstructor
@Getter
@Table(name = "users")
@Entity
public class User extends BaseEntity {

    private String name;
    private String email;
    private String password;
    private LocalDate birthday;

    public User(String name, String email, String password, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public boolean isMatch(Encryptor encryptor, String password) {
        return encryptor.isMatch(password, this.password);
    }
}
