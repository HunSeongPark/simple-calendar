package com.hunseong.calendar.api.service;

import com.hunseong.calendar.api.dto.AuthUser;
import com.hunseong.calendar.api.dto.ScheduleDto;
import com.hunseong.calendar.api.util.DtoConverter;
import com.hunseong.calendar.core.domain.entity.repository.EngagementRepository;
import com.hunseong.calendar.core.domain.entity.repository.ScheduleRepository;
import com.hunseong.calendar.core.util.Period;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Hunseong on 2022/06/10
 */
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;
    private final EngagementRepository engagementRepository;

    public List<ScheduleDto> getScheduleByDay(AuthUser authUser, LocalDate date) {
        return getSchedulesByPeriod(authUser, Period.of(date, date));
    }

    public List<ScheduleDto> getScheduleByWeek(AuthUser authUser, LocalDate startOfWeek) {
        return getSchedulesByPeriod(authUser,
                Period.of(startOfWeek, startOfWeek.plusDays(6)));
    }

    public List<ScheduleDto> getScheduleByMonth(AuthUser authUser, YearMonth yearMonth) {
        return getSchedulesByPeriod(authUser,
                Period.of(yearMonth.atDay(1), yearMonth.atEndOfMonth()));
    }

    private List<ScheduleDto> getSchedulesByPeriod(AuthUser authUser, Period period) {
        return Stream.concat(
                scheduleRepository.findAllByWriter_Id(authUser.getId())
                        .stream()
                        // 쿼리를 수정하여 가져오는 쿼리를 통해 가져오는 리소스의 양을 줄이는 방법도 존재.
                        // 장단점에 따라 선택
                        .filter(schedule -> schedule.isOverlapped(period))
                        .map(DtoConverter::fromSchedule),
                engagementRepository.findAllByAttendee_Id(authUser.getId())
                        .stream()
                        .filter(engagement -> engagement.isOverlapped(period))
                        .map(engagement -> DtoConverter.fromSchedule(engagement.getSchedule()))
        ).toList();
    }
}
