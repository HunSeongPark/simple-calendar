package com.hunseong.calendar.api.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by Hunseong on 2022/06/09
 */
@Data
public class SignUpReq {
    private final String name;
    private final String email;
    private final String password;
    private final LocalDate birthday;
}
