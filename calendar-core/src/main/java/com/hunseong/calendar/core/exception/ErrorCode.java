package com.hunseong.calendar.core.exception;

import lombok.Getter;

/**
 * Created by Hunseong on 2022/06/10
 */
@Getter
public enum ErrorCode {
    PASSWORD_OR_EMAIL_NOT_MATCH("잘못된 이메일 또는 패스워드"),
    ALREADY_EXISTS_USER("이미 존재하는 계정"),
    USER_NOT_FOUND("존재하지 않는 계정"),
    VALIDATION_FAIL("유효하지 않은 값"),
    BAD_REQUEST("잘못된 접근"),
    EVENT_CREATE_OVERLAPPED_PERIOD("이벤트 기간 중복")
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
