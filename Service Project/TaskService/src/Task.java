public class Task {
	private static int taskCount = 0;
	private final String taskIdNum;
	private String taskName;
	private String taskDesc;
	
	
	// Task Constructor
	public Task(String name, String desc) {
		this.taskIdNum = generateTaskId();
		
		// Validate and set task name
        if (name != null && name.length() <= 20) {
            this.taskName = name;
        } 
        else {
            throw new IllegalArgumentException("Task name must not be null and cannot exceed 20 characters.");
        }

        // Validate and set task description
        if (desc != null && desc.length() <= 50) {
            this.taskDesc = desc;
        } 
        else {
            throw new IllegalArgumentException("Task description must not be null and cannot exceed 50 characters.");
        }
	}
	
	// TaskID getter
	public String getTaskIdNumber() {
		return taskIdNum;
	}
	
	// Task Name getter
	public String getTaskName() {
		return taskName;
	}
	
	// Task Name setter
	public void setTaskName(String newTaskName) {
		if (newTaskName != null && newTaskName.length() <= 20) {
			this.taskName = newTaskName;
		}
		else {
			throw new IllegalArgumentException("Task name must not be null and cannot exceed 20 characters.");
		}
	}
	
	// Task Description getter
	public String getTaskDesc() {
		return taskDesc;
	}
	
	// Task Description setter
	public void setTaskDesc(String newTaskDesc) {
		if (newTaskDesc != null && newTaskDesc.length() <= 50) {
			this.taskDesc = newTaskDesc;
		}
		else {
			throw new IllegalArgumentException("Task description must not be null and cannot exceed 50 characters.");
		}
	}
	
	// Task ID generator
	private static synchronized String generateTaskId() {
		String genTaskIdNum = String.valueOf(++taskCount);
		if (genTaskIdNum.length() > 10) {
	        throw new IllegalStateException("Generated task ID exceeds 10 characters.");
	    }
		else {
			return genTaskIdNum;
		}
	}
}