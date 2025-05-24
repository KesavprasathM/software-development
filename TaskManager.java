import java.io.*;
import java.util.*;

public class TaskManager {
    private static final String FILE_NAME = "tasks.txt";
    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadTasks();
        int choice;
        do {
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. View Tasks\n2. Add Task\n3. Update Task\n4. Delete Task\n5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: viewTasks(); break;
                case 2: addTask(); break;
                case 3: updateTask(); break;
                case 4: deleteTask(); break;
                case 5: saveTasks(); System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    private static void loadTasks() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(Task.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No existing tasks found. Starting fresh.");
        }
    }

    private static void saveTasks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                bw.write(task.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId() + " | Title: " + task.getTitle() + " | Status: " + task.getStatus());
        }
    }

    private static void addTask() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter status (Pending/Done): ");
        String status = scanner.nextLine();
        int id = tasks.size() == 0 ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        tasks.add(new Task(id, title, status));
        System.out.println("Task added.");
    }

    private static void updateTask() {
        System.out.print("Enter task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.print("Enter new title: ");
                task.setTitle(scanner.nextLine());
                System.out.print("Enter new status: ");
                task.setStatus(scanner.nextLine());
                System.out.println("Task updated.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted if ID was found.");
    }
}