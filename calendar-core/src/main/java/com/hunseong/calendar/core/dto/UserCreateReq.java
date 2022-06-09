package com.hunseong.calendar.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by Hunseong on 2022/06/09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateReq {
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;
}
