package com.hunseong.calendar.core.domain;

import lombok.AllArgsConstructor;
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

    private Long id;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String title;
    private String description;
    private User writer;
    private LocalDateTime createdAt;
    private List<Engagement> engagements;

    public Event(LocalDateTime startAt, LocalDateTime endAt, String title, String description, User writer, LocalDateTime createdAt) {
        this.startAt = startAt;
        this.endAt = endAt;
        this.title = title;
        this.description = description;
        this.writer = writer;
        this.createdAt = createdAt;
    }

    public void addEngagement(Engagement engagement) {
        if (engagements == null) {
            engagements = List.of(engagement);
        } else {
            engagements.add(engagement);
        }
    }
}
