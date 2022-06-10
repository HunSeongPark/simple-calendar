package com.hunseong.calendar.core.service;

import com.hunseong.calendar.core.domain.entity.User;
import com.hunseong.calendar.core.domain.entity.repository.UserRepository;
import com.hunseong.calendar.core.dto.UserCreateReq;
import com.hunseong.calendar.core.exception.CalendarException;
import com.hunseong.calendar.core.exception.ErrorCode;
import com.hunseong.calendar.core.util.Encryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Hunseong on 2022/06/09
 */
@RequiredArgsConstructor
@Service
public class UserService {

    private final Encryptor encryptor;
    private final UserRepository userRepository;

    @Transactional
    public User create(UserCreateReq userCreateReq) {
        userRepository.findByEmail(userCreateReq.getEmail())
                .ifPresent(user -> {
                    throw new CalendarException(ErrorCode.ALREADY_EXISTS_USER);
                });
        return userRepository.save(new User(
                userCreateReq.getName(),
                userCreateReq.getEmail(),
                encryptor.encrypt(userCreateReq.getPassword()),
                userCreateReq.getBirthday()
        ));
    }

    @Transactional
    public Optional<User> findPwMatchUser(String email, String password) {
        // strategy pattern
        // User 객체에 대한 기능테스트 편리
        return userRepository.findByEmail(email)
                .map(user -> user.isMatch(encryptor, password) ? user : null);
    }

    @Transactional
    public User findByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CalendarException(ErrorCode.USER_NOT_FOUND));
    }
}
