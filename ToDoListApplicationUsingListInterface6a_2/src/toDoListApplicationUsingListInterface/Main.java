package toDoListApplicationUsingListInterface;

public class Main {
	public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask("Go shopping");
        toDoList.addTask("Clean the house");
        toDoList.displayTasks();
        
        toDoList.updateTask(1, "Clean the car");
        toDoList.displayTasks();
        
        toDoList.removeTask(0);
        toDoList.displayTasks();
    }
}