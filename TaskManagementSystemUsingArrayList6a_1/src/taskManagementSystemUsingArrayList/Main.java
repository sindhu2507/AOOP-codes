package taskManagementSystemUsingArrayList;

public class Main {
	public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Finish homework");
        taskManager.addTask("Read a book");
        taskManager.displayTasks();
        
        taskManager.updateTask(1, "Read a novel");
        taskManager.displayTasks();
        
        taskManager.removeTask(0);
        taskManager.displayTasks();
    }
}
