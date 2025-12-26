package taskflow;

import taskflow.exceptions.TaskNotFoundException;
import taskflow.model.*;
import taskflow.service.TaskService;

public class Main {
    public static void main(String[] args) {
        TaskService taskManager = new TaskService();

        System.out.println("🚀 STARTING TASK FLOW \n");

        Task t1 = new Bug(101, "Login Button Crash", Priority.CRITICAL, "Severe");
        Task t2 = new Feature(102, "Dark Mode", Priority.LOW, "2024-12-31");
        Task t3 = new Bug(103, "Typo on Home Page", Priority.LOW, "Minor");
        Task t4 = new Feature(104, "Payment Integration", Priority.HIGH, "2024-06-01");

        taskManager.addTask(t1);
        taskManager.addTask(t2);
        taskManager.addTask(t3);
        taskManager.addTask(t4);

        System.out.println("\n📋 ALL TASKS (Sorted by Priority):");
        taskManager.getAllTasksSorted().forEach(t ->
                System.out.println(t.getDetails())
        );

        System.out.println("\n🔄 PROCESSING TASKS...");
        try {
            taskManager.markTaskAsDone(101);
            taskManager.markTaskAsDone(999);
        } catch (TaskNotFoundException e) {
            System.out.println("⚠️ ERROR CAUGHT: " + e.getMessage());
        }

        taskManager.printStatistics();

        System.out.println("\n✅ SYSTEM SHUTDOWN.");
    }
}