import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
	private Task taskPASS;
	private Task taskUniqueIdPass;
	private Task taskFailNameNotNull;
	private Task taskFailNameLength;
	private Task taskFailDescNotNull;
	private Task taskFailDescLength;
	
	@BeforeEach
	// Create dummy tasks to use for testing
	void setUp() {
		taskPASS = new Task("Fold laundry", "Fold and put away laundry.");
		taskUniqueIdPass = new Task("Groom dog", "Give dog a bath and brush");
		taskFailNameNotNull = new Task(null, "Tidy room");
		taskFailNameLength = new Task("I need to set an appointment with the doctor", "Set appointment");
		taskFailDescNotNull = new Task("Clean car", null);
		taskFailDescLength = new Task("Make bed", "Take off old sheets, place in hamper, put on new sheets, put on new pillow cases, place new comforter.");
	}
	
	// Tests for TaskIdNum
	@Test
	void testTaskIdNumNotNull() {
		assertNotNull(taskPASS.getTaskIdNumber());
		// This test shows that an ID number is being generated for the task
	}
	
	@Test
	void testTaskIdNumNotExceed10Char() {
		assertTrue(taskPASS.getTaskIdNumber().length() <= 10);
		// This test shows that the ID number generated is not exceeding 10 characters
	}
	
	@Test
	void testTaskIdNumUnique() {
		assertNotEquals(taskPASS.getTaskIdNumber(), taskUniqueIdPass.getTaskIdNumber());
		// This test shows that each task has a unique ID number
	}
	
	
	// Tests for taskName
	@Test
	void testTaskNameNotNullPass() {
		assertNotNull(taskPASS.getTaskName());
		// This test shows that the task name is not null
	}
	
	@Test
	void testTaskNameNotNullFail() {
		assertNotNull(taskFailNameNotNull.getTaskName());
		// This test shows that the application won't allow a null task name
	}
	
	@Test
	void testTaskNameNotExceed20CharPass() {
		assertTrue(taskPASS.getTaskName().length()<= 20);
		// This test shows that the task name doesn't exceed 20 characters
	}
	
	@Test
	void testTaskNameNotExceed20CharFail() {
		assertTrue(taskFailNameLength.getTaskName().length()<= 20);
		// This test shows that the application won't allow a task name longer than 20 characters
	}
	
	// Tests for task description
	@Test
	void testTaskDescriptionNotNullPass() {
		assertNotNull(taskPASS.getTaskDesc());
		// This test shows that the task description is not null
	}
	
	@Test
	void testTaskDescriptionNotNullFail() {
		assertNotNull(taskFailDescNotNull.getTaskDesc());
		// This test shows that the application won't allow a null task description
	}
	
	@Test
	void testTaskDescriptionNotExceed50CharPass() {
		assertTrue(taskPASS.getTaskDesc().length() <= 50);
		// This test shows that the task description doesn't exceed 50 characters
	}
	
	@Test
	void testTaskDescriptionNotExceed50CharFail() {
		assertTrue(taskFailDescLength.getTaskDesc().length() <= 50);
		// This test shows that the application won't allow a task description longer than 50 characters
	}
}