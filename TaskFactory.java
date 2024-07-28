package ASTRONAUT;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        // Optionally add validation here
        return new Task(description, startTime, endTime, priority);
    }
}