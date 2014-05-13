package net.goeller.trackerfx.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Christian on 10.05.2014.
 */
public class TaskRecorder {

    private final List<Task> tasks = new ArrayList<>();

    private Task currentTask;

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public Task createNewTask() {
        stopCurrentTask();

        Task task = new Task();
        tasks.add(task);
        currentTask = task;
        return task;
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        if (currentTask == task) {
            currentTask = null;
        }
    }

    public void startTask(Task task) {
        stopCurrentTask();

        currentTask = task;
        task.start();
        if (!tasks.contains(task)) {
            tasks.add(task);
        }
    }

    public void stopCurrentTask() {
        if (currentTask != null) {
            currentTask.stop();
            currentTask = null;
        }
    }
}
