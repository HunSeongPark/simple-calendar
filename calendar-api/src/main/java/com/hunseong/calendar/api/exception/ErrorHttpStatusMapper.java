package com.hunseong.calendar.api.exception;

import com.hunseong.calendar.core.exception.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * Created by Hunseong on 2022/06/10
 */
public abstract class ErrorHttpStatusMapper {
    public static HttpStatus mapToStatus(ErrorCode errorCode) {
        return switch (errorCode) {
            case ALREADY_EXISTS_USER,
                    VALIDATION_FAIL,
                    BAD_REQUEST,
                    EVENT_CREATE_OVERLAPPED_PERIOD -> HttpStatus.BAD_REQUEST;
            case PASSWORD_OR_EMAIL_NOT_MATCH,
                    USER_NOT_FOUND -> HttpStatus.UNAUTHORIZED;
        };
    }
}
