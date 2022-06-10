package com.hunseong.calendar.core.exception;

import lombok.Getter;

/**
 * Created by Hunseong on 2022/06/10
 */
@Getter
public class CalendarException extends RuntimeException {
    private final ErrorCode errorCode;

    public CalendarException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
