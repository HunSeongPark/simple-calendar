package com.hunseong.calendar.api.util;

import com.hunseong.calendar.api.dto.EventDto;
import com.hunseong.calendar.api.dto.NotificationDto;
import com.hunseong.calendar.api.dto.ScheduleDto;
import com.hunseong.calendar.api.dto.TaskDto;
import com.hunseong.calendar.core.domain.entity.Schedule;
import com.hunseong.calendar.core.exception.CalendarException;
import com.hunseong.calendar.core.exception.ErrorCode;

/**
 * Created by Hunseong on 2022/06/10
 */
public abstract class DtoConverter {
    public static ScheduleDto fromSchedule(Schedule schedule) {
        return switch (schedule.getScheduleType()) {
            case EVENT -> EventDto.builder()
                    .scheduleId(schedule.getId())
                    .description(schedule.getDescription())
                    .startAt(schedule.getStartAt())
                    .endAt(schedule.getEndAt())
                    .title(schedule.getTitle())
                    .writerId(schedule.getWriter().getId())
                    .build();
            case TASK -> TaskDto.builder()
                    .scheduleId(schedule.getId())
                    .description(schedule.getDescription())
                    .taskAt(schedule.getStartAt())
                    .title(schedule.getTitle())
                    .writerId(schedule.getWriter().getId())
                    .build();
            case NOTIFICATION -> NotificationDto.builder()
                    .scheduleId(schedule.getId())
                    .notifyAt(schedule.getStartAt())
                    .title(schedule.getTitle())
                    .writerId(schedule.getWriter().getId())
                    .build();
        };
    }
}
