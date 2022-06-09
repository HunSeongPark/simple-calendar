package com.hunseong.calendar.api.service;

import com.hunseong.calendar.core.domain.entity.Engagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
* Created by Hunseong on 2022/06/10
*/
@Profile("dev")
@Slf4j
@Service
public class FakeEmailService implements EmailService {

    @Override
    public void sendEngagement(Engagement engagement) {
      log.info("send email. email:" + engagement.getAttendee().getEmail() + "scheduleId:" + engagement.getSchedule().getId());
    }
}
