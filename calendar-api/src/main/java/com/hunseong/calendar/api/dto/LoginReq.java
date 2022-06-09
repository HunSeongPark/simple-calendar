package com.hunseong.calendar.api.dto;

import lombok.Data;

/**
 * Created by Hunseong on 2022/06/09
 */
@Data
public class LoginReq {
    private final String email;
    private final String password;
}
