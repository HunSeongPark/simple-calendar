package com.hunseong.calendar.api.service;

import com.hunseong.calendar.api.dto.AuthUser;
import com.hunseong.calendar.api.dto.NotificationCreateReq;
import com.hunseong.calendar.core.domain.entity.Schedule;
import com.hunseong.calendar.core.domain.entity.User;
import com.hunseong.calendar.core.domain.entity.repository.ScheduleRepository;
import com.hunseong.calendar.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Hunseong on 2022/06/10
 */
@RequiredArgsConstructor
@Service
public class NotificationService {

    private final UserService userService;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void create(NotificationCreateReq notificationCreateReq, AuthUser authUser) {
        final User user = userService.findByUserId(authUser.getId());
        final List<LocalDateTime> notifyAtList = notificationCreateReq.getRepeatTimes();
        notifyAtList.forEach(notifyAt -> {
            final Schedule notificationSchedule = Schedule.notification(
                    notificationCreateReq.getTitle(),
                    notifyAt,
                    user
            );
            scheduleRepository.save(notificationSchedule);
        });
    }
}
