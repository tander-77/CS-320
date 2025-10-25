package taskService;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private final Map<String, Task> tasks = new HashMap<>();
	
	public void addTask(Task task) {
		if (tasks.containsKey(task.getTaskId())) {
			throw new IllegalArgumentException("Task ID Already Exists");
		}
		tasks.put(task.getTaskId(), task);
	}
	
	public void deleteTask(String taskId) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID Does Not Exist");
		}
		tasks.remove(taskId);
	}
	
	public void updateTask(String taskId, String name, String description) {
		Task task = tasks.get(taskId);
		if (task == null) {
			throw new IllegalArgumentException("Task ID Does Not Exist");
		}
		if (name != null && !name.isEmpty()) {
			task.setName(name);
		}
		if (description != null && !description.isEmpty()) {
			// added print command to verify the correct update of task name and description 
			System.out.println("Updating description from: " + task.getDescription() + " to: " + description);
			task.setDescription(description);
		}
		
		tasks.put(taskId, task);
	}
	
	public Task getTaskById(String taskId) {
		return tasks.get(taskId);
	}
}
