package net.goeller.trackerfx.task;

import java.time.Duration;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Christian on 10.05.2014.
 */
public class Task {
    private String name;
    private Deque<WorkUnit> workUnits = new LinkedList<>();

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void start() {
        WorkUnit workUnit = workUnits.peekLast();
        if (workUnit == null || !workUnit.isRunning()) {
            workUnits.addLast(new WorkUnit());
        }
    }

    public void stop() {
        WorkUnit workUnit = workUnits.peekLast();
        if (workUnit != null && workUnit.isRunning()) {
            workUnit.stopEvent();
        }
    }

    @Override
    public String toString() {

        long seconds = workUnits.stream().mapToLong(w -> w.getDuration().getSeconds()).sum();
        Duration sum = Duration.ofSeconds(seconds);

        return "Task: " + name + ", total duration: " + TimeFormatter.format(sum);
    }
}
