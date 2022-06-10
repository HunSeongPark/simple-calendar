package com.hunseong.calendar.api.service;

import com.hunseong.calendar.api.dto.LoginReq;
import com.hunseong.calendar.api.dto.SignUpReq;
import com.hunseong.calendar.core.domain.entity.User;
import com.hunseong.calendar.core.dto.UserCreateReq;
import com.hunseong.calendar.core.exception.CalendarException;
import com.hunseong.calendar.core.exception.ErrorCode;
import com.hunseong.calendar.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.security.Key;
import java.util.Optional;

/**
 * Created by Hunseong on 2022/06/09
 */
@Service
@RequiredArgsConstructor
public class LoginService {

    public static final String LOGIN_SESSION_KEY = "USER_ID";
    private final UserService userService;

    @Transactional
    public void signUp(SignUpReq signUpReq, HttpSession session) {
        final User user = userService.create(new UserCreateReq(
                signUpReq.getName(),
                signUpReq.getEmail(),
                signUpReq.getPassword(),
                signUpReq.getBirthday()
        ));
        session.setAttribute(LOGIN_SESSION_KEY, user.getId());
    }

    @Transactional
    public void login(LoginReq loginReq, HttpSession session) {
        final Long userId = (Long) session.getAttribute(LOGIN_SESSION_KEY);
        if (userId != null) {
            return;
        }
        final Optional<User> user = userService.findPwMatchUser(loginReq.getEmail(), loginReq.getPassword());
        if (user.isPresent()) {
            session.setAttribute(LOGIN_SESSION_KEY, user.get().getId());
        } else {
            throw new CalendarException(ErrorCode.PASSWORD_OR_EMAIL_NOT_MATCH);
        }
    }

    public void logout(HttpSession session) {
        session.removeAttribute(LOGIN_SESSION_KEY);
    }
}
