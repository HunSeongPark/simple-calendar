package com.hunseong.calendar.core;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hunseong on 2022/06/09
 */
public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Long> {
}
