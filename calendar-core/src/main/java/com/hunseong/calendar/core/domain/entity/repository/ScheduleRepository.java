package com.hunseong.calendar.core.domain.entity.repository;

import com.hunseong.calendar.core.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hunseong on 2022/06/09
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}