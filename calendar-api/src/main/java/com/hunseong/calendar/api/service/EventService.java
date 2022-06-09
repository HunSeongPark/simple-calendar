package com.hunseong.calendar.api.service;

import com.hunseong.calendar.api.dto.AuthUser;
import com.hunseong.calendar.api.dto.EventCreateReq;
import com.hunseong.calendar.core.domain.RequestStatus;
import com.hunseong.calendar.core.domain.entity.Engagement;
import com.hunseong.calendar.core.domain.entity.Schedule;
import com.hunseong.calendar.core.domain.entity.User;
import com.hunseong.calendar.core.domain.entity.repository.EngagementRepository;
import com.hunseong.calendar.core.domain.entity.repository.ScheduleRepository;
import com.hunseong.calendar.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/09
 */
@RequiredArgsConstructor
@Service
public class EventService {

    private final EngagementRepository engagementRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserService userService;
    private final EmailService emailService;

    public void create(EventCreateReq eventCreateReq, AuthUser authUser) {
        final List<Engagement> engagementList = engagementRepository.findAll();
        if (engagementList.stream().anyMatch(e -> eventCreateReq.getAttendeeIds().contains(e.getAttendee().getId())
                && e.getRequestStatus() == RequestStatus.ACCEPTED
                && e.getEvent().isOverlapped(eventCreateReq.getStartAt(), eventCreateReq.getEndAt())
        )) {
            throw new RuntimeException("cannot make engagement. period overlapped!");
        }
        final Schedule eventSchedule = Schedule.event(
                eventCreateReq.getTitle(),
                eventCreateReq.getDescription(),
                eventCreateReq.getStartAt(),
                eventCreateReq.getEndAt(),
                userService.findByUserId(authUser.getId())
        );
        scheduleRepository.save(eventSchedule);
        eventCreateReq.getAttendeeIds()
                .forEach(atId -> {
                    final User attendee = userService.findByUserId(atId);
                    final Engagement engagement = Engagement.builder()
                            .schedule(eventSchedule)
                            .requestStatus(RequestStatus.REQUESTED)
                            .attendee(attendee)
                            .build();
                    engagementRepository.save(engagement);
                    emailService.sendEngagement(engagement);
                });
    }
}
