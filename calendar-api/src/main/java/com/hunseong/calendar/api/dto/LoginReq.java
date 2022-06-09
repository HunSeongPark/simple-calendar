package com.hunseong.calendar.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Hunseong on 2022/06/09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {
    private String email;
    private String password;
}
