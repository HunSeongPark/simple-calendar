package com.hunseong.calendar.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Hunseong on 2022/06/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateReq {
    private String title;
    private String description;
    private LocalDateTime taskAt;
}
