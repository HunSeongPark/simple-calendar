package com.hunseong.calendar.api.dto;

import com.hunseong.calendar.core.util.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Hunseong on 2022/06/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationCreateReq {

    private String title;
    private LocalDateTime notifyAt;
    private RepeatInfo repeatInfo;

    public List<LocalDateTime> getRepeatTimes() {
        if (repeatInfo == null) {
            return List.of(notifyAt);
        }
        return IntStream.range(0, repeatInfo.times)
                .mapToObj(i -> {
                    long inc = (long) repeatInfo.interval.intervalValue * i;
                    return switch (repeatInfo.getInterval().timeUnit) {
                        case DAY -> notifyAt.plusDays(inc);
                        case WEEK -> notifyAt.plusWeeks(inc);
                        case MONTH -> notifyAt.plusMonths(inc);
                        case YEAR -> notifyAt.plusYears(inc);
                        default -> throw new RuntimeException("bad request. not match time unit!");
                    };
                })
                .collect(Collectors.toList());
    }

    @Data
    public static class RepeatInfo {
        private Interval interval;
        private int times;
    }

    @Data
    public static class Interval {
        private int intervalValue;
        private TimeUnit timeUnit;
    }
}
