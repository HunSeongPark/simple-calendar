package com.hunseong.calendar.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Hunseong on 2022/06/09
 */
@Getter
@NoArgsConstructor
public class AuthUser {
    private Long id;

    private AuthUser(Long id) {
        this.id = id;
    }

    public static AuthUser of(Long id) {
        return new AuthUser(id);
    }
}
