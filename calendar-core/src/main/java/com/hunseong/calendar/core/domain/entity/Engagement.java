package com.hunseong.calendar.core.domain.entity;

import com.hunseong.calendar.core.domain.Event;
import com.hunseong.calendar.core.domain.RequestStatus;
import com.hunseong.calendar.core.util.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Hunseong on 2022/06/09
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "engagements")
@Entity
public class Engagement extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "attendee_id")
    private User attendee;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    public Event getEvent() {
        return schedule.toEvent();
    }

    public boolean isOverlapped(LocalDate date) {
        return Period.of(schedule.getStartAt(), schedule.getEndAt()).isOverlapped(date);
    }

    public boolean isOverlapped(Period period) {
        return Period.of(schedule.getStartAt(), schedule.getEndAt()).isOverlapped(period);
    }
}
