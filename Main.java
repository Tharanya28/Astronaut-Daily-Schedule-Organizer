package ASTRONAUT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Example: Adding some tasks
        scheduleManager.addTask(TaskFactory.createTask("Morning Exercise", "07:00", "08:00", "High"));
        scheduleManager.addTask(TaskFactory.createTask("Team Meeting", "09:00", "10:00", "Medium"));
        scheduleManager.addTask(TaskFactory.createTask("Lunch Break", "12:00", "13:00", "Low"));
        scheduleManager.viewTasks();

        // Interactive console for adding/removing/viewing tasks
        boolean exit = false;
        while (!exit) {
            System.out.println("\nOptions: (1) Add Task (2) Remove Task (3) View Tasks (4) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter task description:");
                    String description = scanner.nextLine();
                    System.out.println("Enter start time (HH:mm):");
                    String startTime = scanner.nextLine();
                    System.out.println("Enter end time (HH:mm):");
                    String endTime = scanner.nextLine();
                    System.out.println("Enter priority (High, Medium, Low):");
                    String priority = scanner.nextLine();
                    scheduleManager.addTask(TaskFactory.createTask(description, startTime, endTime, priority));
                    break;
                case 2:
                    System.out.println("Enter task description to remove:");
                    String descToRemove = scanner.nextLine();
                    scheduleManager.removeTask(descToRemove);
                    break;
                case 3:
                    scheduleManager.viewTasks();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}