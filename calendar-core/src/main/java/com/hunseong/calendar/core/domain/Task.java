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
public class Task {

    private Long id;
    private LocalDateTime taskAt;
    private String title;
    private String description;
    private User writer;
    private LocalDateTime createdAt;

    public Task(LocalDateTime taskAt, String title, String description, User writer, LocalDateTime createdAt) {
        this.taskAt = taskAt;
        this.title = title;
        this.description = description;
        this.writer = writer;
        this.createdAt = createdAt;
    }
}
