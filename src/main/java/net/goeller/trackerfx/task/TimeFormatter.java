package net.goeller.trackerfx.task;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static java.time.temporal.ChronoField.*;

/**
 * Created by Christian on 10.05.2014.
 */
public final class TimeFormatter {

    public static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .appendValue(HOUR_OF_DAY, 2)
            .appendLiteral(':')
            .appendValue(MINUTE_OF_HOUR, 2)
            .optionalStart()
            .appendLiteral(':')
            .appendValue(SECOND_OF_MINUTE, 2).toFormatter();

    public static final String format(Duration duration) {
        LocalTime fTime = LocalTime.ofNanoOfDay(duration.toNanos());
        return fTime.format(FORMATTER);
    }
}
