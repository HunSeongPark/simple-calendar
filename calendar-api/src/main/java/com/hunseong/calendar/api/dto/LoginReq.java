package com.hunseong.calendar.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Hunseong on 2022/06/09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {

    @Email
    @NotNull
    private String email;

    @Size(min = 6, message = "6자리 이상 입력해주세요.")
    @NotBlank
    private String password;
}
