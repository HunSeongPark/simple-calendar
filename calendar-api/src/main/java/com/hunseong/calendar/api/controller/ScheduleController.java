package com.hunseong.calendar.api.controller;

import com.hunseong.calendar.api.dto.*;
import com.hunseong.calendar.api.service.EventService;
import com.hunseong.calendar.api.service.NotificationService;
import com.hunseong.calendar.api.service.ScheduleQueryService;
import com.hunseong.calendar.api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

/**
 * Created by Hunseong on 2022/06/09
 */
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
@RestController
public class ScheduleController {

    private final ScheduleQueryService scheduleQueryService;
    private final TaskService taskService;
    private final EventService eventService;
    private final NotificationService notificationService;

    @PostMapping("/tasks")
    public ResponseEntity<Void> createTask(@RequestBody TaskCreateReq taskCreateReq, AuthUser authUser) {
        taskService.create(taskCreateReq, authUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/events")
    public ResponseEntity<Void> createEvent(@RequestBody EventCreateReq eventCreateReq, AuthUser authUser) {
        eventService.create(eventCreateReq, authUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/notifications")
    public ResponseEntity<Void> createNotifications(@RequestBody NotificationCreateReq notificationCreateReq, AuthUser authUser) {
        notificationService.create(notificationCreateReq, authUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/day")
    public List<ScheduleDto> getScheduleByDay(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            AuthUser authUser
    ) {
        return scheduleQueryService.getScheduleByDay(authUser, date == null ? LocalDate.now() : date);
    }

    @GetMapping("/week")
    public List<ScheduleDto> getScheduleByWeek(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startOfWeek,
            AuthUser authUser
    ) {
        return scheduleQueryService.getScheduleByWeek(authUser, startOfWeek == null ? LocalDate.now() : startOfWeek);
    }

    @GetMapping("/month")
    public List<ScheduleDto> getScheduleByMonth(
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM") String yearMonth, // 2022-06
            AuthUser authUser
    ) {
        return scheduleQueryService.getScheduleByMonth(
                authUser, yearMonth == null ? YearMonth.now() : YearMonth.parse(yearMonth));
    }
}
