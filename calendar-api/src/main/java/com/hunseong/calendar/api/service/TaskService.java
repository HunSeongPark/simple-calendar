package com.hunseong.calendar.api.service;

import com.hunseong.calendar.api.dto.AuthUser;
import com.hunseong.calendar.api.dto.TaskCreateReq;
import com.hunseong.calendar.core.domain.entity.Schedule;
import com.hunseong.calendar.core.domain.entity.repository.ScheduleRepository;
import com.hunseong.calendar.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Hunseong on 2022/06/09
 */
@RequiredArgsConstructor
@Service
public class TaskService {

    private final UserService userService;
    private final ScheduleRepository scheduleRepository;

    public void create(TaskCreateReq taskCreateReq, AuthUser authUser) {
        final Schedule taskSchedule =
                Schedule.task(
                        taskCreateReq.getTitle(),
                        taskCreateReq.getDescription(),
                        taskCreateReq.getTaskAt(),
                        userService.findByUserId(authUser.getId()));
        scheduleRepository.save(taskSchedule);
    }
}
