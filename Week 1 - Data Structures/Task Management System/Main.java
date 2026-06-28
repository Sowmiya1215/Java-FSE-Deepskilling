public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        taskList.addTask(new Task(1, "Design UI", "Pending"));
        taskList.addTask(new Task(2, "Develop Backend", "In Progress"));
        taskList.addTask(new Task(3, "Test Module", "Pending"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();
        System.out.println("\nSearching for task ID 2:");
        Task found = taskList.searchTask(2);
        if (found != null)
            System.out.println("Found: " + found);
        else
            System.out.println("Task not found.");
        System.out.println("\nDeleting task ID 1:");
        taskList.deleteTask(1);

        System.out.println("\nTasks after deletion:");
        taskList.traverseTasks();
    }
}
