/* Developer: Rachel Siminski 
 * Date: 6/2/2024
 * Title: TaskService
 * 
 * Notes: I forgot to include an informational comment in my previous assignment.
 * This application is a task list service. The user is prompted with a Main Menu, and can choose from a list
 *  of options. The options include ADD a new task, UPDATE a task, DELETE a task, DISPLAY task list, and EXIT. 
 *  Each task consists of a unique, auto-generated Task ID Number, a Task Name, and a Task Description. The user 
 *  will provide the task name and task description, and these fields can be updated at any time. The task id 
 *  cannot be changed once set, and can not be set by the user.
 */


import java.util.ArrayList;
import java.util.Scanner;


public class TaskService {
	// Declare and initialize Task List ArrayList
    private ArrayList<Task> taskList = new ArrayList<Task>();

    // Add task to Task List
    public void addTask(String name, String desc) {
        Task newTask = new Task(name, desc);
        taskList.add(newTask);
    }

    // Search task list for given task ID
    public Task searchTaskList(String taskIdNum) {
        for (Task task : taskList) {
            if (task.getTaskIdNumber().equalsIgnoreCase(taskIdNum)) {
                return task;
            }
        }
        return null; // Return null if no task is found with the given ID
    }
    
    // Update task in Task List
    public void updateTask(String taskIdNum) {
    	Task taskToUpdate = searchTaskList(taskIdNum);
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
    	
    	int choice = 0;
    	
    	if (taskToUpdate != null) {
    		do {
    			System.out.println("Please select which field you would like to update: ");
    			System.out.println("1. Task name");
    			System.out.println("2. Task description");
    			System.out.println("9. Return to main menu");
    			System.out.println();
    			
    			if (scanner.hasNextInt()) {
    				choice = scanner.nextInt();
    				scanner.nextLine();
    			}
    			else {
    				scanner.nextLine();
    				System.out.println("Invalid input. Please enter a number.");
    				choice = 0;
    			}
    			
    			switch (choice) {
    				case 1:
    					System.out.println("Please enter the new task name: ");
    					String newTaskName = scanner.nextLine();
    					
    					try {
    						taskToUpdate.setTaskName(newTaskName);
    					}
    					catch (IllegalArgumentException e) {
    						System.out.println("Unable to update task name: " + e.getMessage());
    					}
    					break;
    					
    				case 2:
    					System.out.println("Please enter the new task description: ");
    					String newTaskDesc = scanner.nextLine();
    					
    					try {
    						taskToUpdate.setTaskDesc(newTaskDesc);
    					}
    					catch (IllegalArgumentException e) {
    						System.out.println("Unable to update task description: " + e.getMessage());
    					}
    					break;
    					
    				case 9:
    					break;
    					
    				default:
    					System.out.println("Invalid input. Please select from the listed choices.");
    			}
    			
    			System.out.println("ID: " + taskToUpdate.getTaskIdNumber());
    			System.out.println("Task Name: " + taskToUpdate.getTaskName());
    			System.out.println("Task Description: " + taskToUpdate.getTaskDesc());
    			System.out.println();
    			
    		} 
    		while (choice !=9);
    	}
    }
    
    // Delete task from Task List
    public void deleteTask(String taskIdNum) {
        Task taskToDelete = searchTaskList(taskIdNum);
        if (taskToDelete != null) {
            taskList.remove(taskToDelete);
            System.out.println("Task deleted successfully.");
        } 
        else {
            System.out.println("Task not found.");
        }
    }
    
    // Display task list
    public void displayTaskList() {
    	System.out.println("   TASK LIST   ");
    	for (Task task: taskList) {
    		System.out.println("Task ID: " + task.getTaskIdNumber());
    		System.out.println("Task Name: " + task.getTaskName());
    		System.out.println("Task Description: " + task.getTaskDesc());
    		System.out.println();
    	}
    }
	
	public static void main(String[] args) {
		// Create new instance of Task Service
		TaskService taskService = new TaskService();
		Scanner scanner = new Scanner(System.in);
    	
    	int choice = 0;
    	
    	do {
    		System.out.println("  Main Menu  ");
    		System.out.println("Please select from an option below.");
    		System.out.println("1. Create new task");
    		System.out.println("2. Update existing task");
    		System.out.println("3. Delete task");
    		System.out.println("4. Display task list");
    		System.out.println("9. Exit");
    		System.out.println();
    			
    		if (scanner.hasNextInt()) {
    			choice = scanner.nextInt();
    			scanner.nextLine(); // Consume newline input
    			
    			switch (choice) {
    			// Create new task
    			case 1:
    				System.out.println("Please enter the following information: ");
    				System.out.println("Task name:");
    				String name = scanner.nextLine();
    				
    				System.out.println("Task description:");
    				String desc = scanner.nextLine();
    				
    				try {
    					taskService.addTask(name, desc);
    					System.out.println("Task added successfully!");
    				} 
    				catch (IllegalArgumentException e) {
    					System.out.println("Unable to add task: " + e.getMessage());
    				}
    				break;
    				
    			// Update task
    			case 2:
    				System.out.println("Please enter the ID number for the task you would like to update:");
    				String taskIdNum = scanner.nextLine();
    				
    				taskService.updateTask(taskIdNum);
    				break;
    				
    			// Delete task
    			case 3:
    				System.out.println("Please enter the ID for the task you would like to delete:");
    				String taskDelete = scanner.nextLine();
    				
    				taskService.deleteTask(taskDelete);
    				break;
    				
    			// Display task list
    			case 4:
    				taskService.displayTaskList();
    				break;
    			
    			// Exit application
    			case 9:
    				System.out.println("Goodbye.");
    				break;
    			// Default
    			default:
    				System.out.println("Invalid input. Please select from the menu options above.");
    				break;
    			}
    		} 
    	}
    	while (choice !=9);
    		
    	scanner.close();
	}
}