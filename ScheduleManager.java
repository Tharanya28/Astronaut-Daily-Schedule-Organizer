package ASTRONAUT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        if (validateTask(task)) {
            tasks.add(task);
            System.out.println("Task added successfully. No conflicts.");
        } else {
            System.out.println("Error: Task conflicts with existing tasks.");
        }
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private boolean validateTask(Task newTask) {
        for (Task task : tasks) {
            if (task.conflictsWith(newTask)) {
                return false;
            }
        }
        return true;
    }
}