package com.hunseong.calendar.core;

import com.hunseong.calendar.core.domain.Engagement;
import com.hunseong.calendar.core.domain.Event;
import com.hunseong.calendar.core.domain.RequestStatus;
import com.hunseong.calendar.core.domain.User;
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
        final User writer = new User("writer", "email@email", "pw", LocalDate.now(), LocalDateTime.now());
        final User attendee = new User("attendee", "email@email", "pw", LocalDate.now(), LocalDateTime.now());
        final Event event = new Event(
                LocalDateTime.now(),
                LocalDateTime.now(),
                "title",
                "desc",
                writer,
                LocalDateTime.now()
        );
        event.addEngagement(new Engagement(event, attendee, LocalDateTime.now(), RequestStatus.REQUESTED));
        assertThat(event.getEngagements().get(0).getEvent().getWriter().getName()).isEqualTo("writer");
    }
}
