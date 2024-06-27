import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	private TaskService taskService;
	
	@BeforeEach
	// Create dummy taskService to use for testing
	void setUpTaskService() {
		taskService = new TaskService();
		
		// Create and add a new task to taskList
		taskService.addTask("Task name", "Task description.");
	}
	
	// Tests for ADD task
	@Test
	void testAddTaskPass() {
		// Search for task
		Task testTaskPASS = taskService.searchTaskList("1");
		
		// Test that task is added correctly
		assertNotNull(testTaskPASS);
		
		// This test shows that the addTask() method is able to add a new task to the task list
	}
	
	@Test
	void testAddTaskPassName() {
		// Search for task
		Task testTaskPASSName = taskService.searchTaskList("1");
		
		// Test that task name is "Task name"
		assertEquals(testTaskPASSName.getTaskName(), "Task name");
		
		// This test shows that the addTask() method has correctly populated the task name field
	}
	
	@Test
	void testAddTaskPassDesc() {
		// Search for task
		Task testTaskPASSDesc = taskService.searchTaskList("1");
		
		// Test that task description is "Task description."
		assertEquals(testTaskPASSDesc.getTaskName(), "Task description.");
		
		// This test shows that addTask() has correctly populated the task description field
	}
	
	// Tests for UPDATE task
	public void prepUpdateTask() {
		// Update task
		taskService.updateTask("1");
		
		// Update task fields
		Task testTask = taskService.searchTaskList("1");
		
		testTask.setTaskName("New Task Name");
		testTask.setTaskDesc("New task description");
	}
	
	@Test
	void testUpdateTaskNamePass() {
		// Search for task
		Task testUpdateNamePASS = taskService.searchTaskList("1");
		
		// Test that task name has updated
		assertEquals(testUpdateNamePASS.getTaskName(), "New Task Name");
		
		// This test shows that the updateTask() method has correctly updated the task name field
	}
	
	@Test
	void testUpdateTaskDescPass() {
		// Search for task
		Task testUpdateDescPASS = taskService.searchTaskList("1");
		
		// Test that task description has updated
		assertEquals(testUpdateDescPASS.getTaskDesc(), "New task description.");
		
		// This test shows that the updateTask() method has correctly updated the task description
	}
	
	
	// Tests for DELETE task
	@Test
	void testDeleteTaskPASS() {
		// Search for task
		Task testDeleteTaskPASS = taskService.searchTaskList("1");
		
		// Delete task
		taskService.deleteTask("1");
		
		// Test that task is deleted (null)
		assertNull(testDeleteTaskPASS);
		
		// This test shows that the deleteTask() method has successfully deleted the task from the application
	}
	
}