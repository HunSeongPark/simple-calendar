package com.hunseong.calendar.core.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by Hunseong on 2022/06/09
 */
@Data
public class UserCreateReq {
    private final String name;
    private final String email;
    private final String password;
    private final LocalDate birthday;
}
