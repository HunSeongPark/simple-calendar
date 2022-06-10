package com.hunseong.calendar.api.dto;

import com.hunseong.calendar.core.domain.ScheduleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Hunseong on 2022/06/10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements ScheduleDto {

    private Long scheduleId;
    private String title;
    private String description;
    private Long writerId;
    private LocalDateTime taskAt;

    @Override
    public ScheduleType getScheduleType() {
        return ScheduleType.TASK;
    }
}
