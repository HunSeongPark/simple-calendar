package com.hunseong.calendar.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Hunseong on 2022/06/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventCreateReq {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private LocalDateTime startAt;

    @NotNull
    private LocalDateTime endAt;

    private List<Long> attendeeIds;
}
