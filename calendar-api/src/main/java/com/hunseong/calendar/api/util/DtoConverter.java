package com.hunseong.calendar.api.util;

import com.hunseong.calendar.api.dto.EventDto;
import com.hunseong.calendar.api.dto.NotificationDto;
import com.hunseong.calendar.api.dto.ScheduleDto;
import com.hunseong.calendar.api.dto.TaskDto;
import com.hunseong.calendar.core.domain.entity.Schedule;

/**
 * Created by Hunseong on 2022/06/10
 */
public abstract class DtoConverter {
    public static ScheduleDto fromSchedule(Schedule schedule) {
        switch (schedule.getScheduleType()) {
            case EVENT:
                return EventDto.builder()
                        .scheduleId(schedule.getId())
                        .description(schedule.getDescription())
                        .startAt(schedule.getStartAt())
                        .endAt(schedule.getEndAt())
                        .title(schedule.getTitle())
                        .writerId(schedule.getWriter().getId())
                        .build();
            case TASK:
                return TaskDto.builder()
                        .scheduleId(schedule.getId())
                        .description(schedule.getDescription())
                        .taskAt(schedule.getStartAt())
                        .title(schedule.getTitle())
                        .writerId(schedule.getWriter().getId())
                        .build();
            case NOTIFICATION:
                return NotificationDto.builder()
                        .scheduleId(schedule.getId())
                        .notifyAt(schedule.getStartAt())
                        .title(schedule.getTitle())
                        .writerId(schedule.getWriter().getId())
                        .build();
            default:
                throw new RuntimeException("bad request. not matched schedule type!");
        }
    }
}
