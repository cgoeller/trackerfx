package net.goeller.trackerfx.task;

import java.time.Duration;
import java.util.LinkedList;

/**
 * Created by Christian on 10.05.2014.
 */
public class Task {
    private String name;
    private LinkedList<WorkUnit> workUnits = new LinkedList<>();

    public Task() {
        this("Unnamed task");
    }

    public Task(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LinkedList<WorkUnit> getWorkUnits() {
        return workUnits;
    }

    public void setWorkUnits(final LinkedList<WorkUnit> workUnits) {
        this.workUnits = workUnits;
    }

    public void start() {
    	final WorkUnit workUnit = workUnits.peekLast();
        if (workUnit == null || !workUnit.isRunning()) {
            workUnits.addLast(new WorkUnit());
        }
    }

    public void stop() {
        final WorkUnit workUnit = workUnits.peekLast();
        if (workUnit != null && workUnit.isRunning()) {
            workUnit.stopEvent();
        }
    }

    @Override
    public String toString() {

    	final long seconds = workUnits.stream().mapToLong(w -> w.getDuration().getSeconds()).sum();
    	final Duration sum = Duration.ofSeconds(seconds);

        return "Task: " + name + ", total duration: " + TimeFormatter.format(sum);
    }
}
