package com.hunseong.calendar.api.service;

import com.hunseong.calendar.core.domain.entity.Engagement;

/**
 * Created by Hunseong on 2022/06/10
 */
public interface EmailService {
    void sendEngagement(Engagement engagement);
}
