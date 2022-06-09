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
public class Notification {

    private Long id;
    private LocalDateTime notifyAt;
    private String title;
    private User writer;
    private LocalDateTime createdAt;

    public Notification(LocalDateTime notifyAt, String title, User writer, LocalDateTime createdAt) {
        this.notifyAt = notifyAt;
        this.title = title;
        this.writer = writer;
        this.createdAt = createdAt;
    }
}
