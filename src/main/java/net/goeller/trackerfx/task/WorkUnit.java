package net.goeller.trackerfx.task;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by Christian on 10.05.2014.
 */
public class WorkUnit {

    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public WorkUnit() {
        startTime = LocalDateTime.now();
    }

    public void stopEvent() {
        if (endTime == null) {
            endTime = LocalDateTime.now();
        }
    }

    public boolean isRunning() {
        return endTime == null;
    }

    public Duration getDuration() {
        LocalDateTime tempEnd = endTime;
        if (tempEnd == null) {
            tempEnd = LocalDateTime.now();
        }
        return Duration.between(startTime, tempEnd);
    }

    @Override
    public String toString() {
        return "Duration: " + TimeFormatter.format(getDuration());
    }
}
