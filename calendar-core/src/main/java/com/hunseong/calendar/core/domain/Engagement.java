package com.hunseong.calendar.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Hunseong on 2022/06/09
 */
@NoArgsConstructor
@Getter
public class Engagement {

    private Long id;
    private Event event;
    private User attendee;
    private LocalDateTime createdAt;
    private RequestStatus requestStatus;

    public Engagement(Event event, User attendee, LocalDateTime createdAt, RequestStatus requestStatus) {
        this.event = event;
        this.attendee = attendee;
        this.createdAt = createdAt;
        this.requestStatus = requestStatus;
    }
}
