package com.hunseong.calendar.api.controller;

import com.hunseong.calendar.api.dto.AuthUser;
import com.hunseong.calendar.api.dto.TaskCreateReq;
import com.hunseong.calendar.api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.hunseong.calendar.api.service.LoginService.LOGIN_SESSION_KEY;

/**
 * Created by Hunseong on 2022/06/09
 */
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
@RestController
public class ScheduleController {

    private final TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Void> createTask(@RequestBody TaskCreateReq taskCreateReq, HttpSession session) {
        final Long userId = (Long) session.getAttribute(LOGIN_SESSION_KEY);
        if (userId == null) {
            throw new RuntimeException("bad request. no session");
        }
        taskService.create(taskCreateReq, AuthUser.of(userId));
        return ResponseEntity.ok().build();
    }
}
