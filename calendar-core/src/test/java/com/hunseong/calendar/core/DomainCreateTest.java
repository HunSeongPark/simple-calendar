package com.hunseong.calendar.core;

import com.hunseong.calendar.core.domain.ScheduleType;
import com.hunseong.calendar.core.domain.entity.Engagement;
import com.hunseong.calendar.core.domain.Event;
import com.hunseong.calendar.core.domain.RequestStatus;
import com.hunseong.calendar.core.domain.entity.Schedule;
import com.hunseong.calendar.core.domain.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Hunseong on 2022/06/09
 */
public class DomainCreateTest {

    @Test
    void eventCreate() {
        final User me = new User("hunseong", "email@email", "pw", LocalDate.now());
        final Schedule taskSchedule = Schedule.task("할일", "청소하기", LocalDateTime.now(), me);

        assertThat(taskSchedule.getScheduleType()).isEqualTo(ScheduleType.TASK);
        assertThat(taskSchedule.toTask().getTitle()).isEqualTo("할일");
        assertThat(taskSchedule.getWriter().getName()).isEqualTo(me.getName());
    }
}
