package com.hunseong.calendar.core.domain;

import com.hunseong.calendar.core.domain.entity.Engagement;
import com.hunseong.calendar.core.domain.entity.Schedule;
import com.hunseong.calendar.core.domain.entity.User;
import com.hunseong.calendar.core.util.Period;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Hunseong on 2022/06/09
 */
@NoArgsConstructor
@Getter
public class Event {
    private Schedule schedule;

    public Event(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isOverlapped(LocalDateTime startAt, LocalDateTime endAt) {
        return Period.of(schedule.getStartAt(), schedule.getEndAt()).isOverlapped(startAt, endAt);
    }
}
