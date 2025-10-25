package taskService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
	@Test
	public void testAddTask() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "Task Name", "Task Description");
		service.addTask(task);
		assertEquals(task, service.getTaskById("12345"));
	}
	
	@Test
	public void testDeleteTask() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "Task Name", "Task Description");
		service.addTask(task);
		service.deleteTask("12345");
		assertNull(service.getTaskById("12345"));
	}
	
	@Test
	public void testUpdateTask() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "Task Name", "Task Description");
		service.addTask(task);
		service.updateTask("12345", "Updated Name", "Updated Description");
		Task updatedTask = service.getTaskById("12345");
		assertEquals("Updated Name", updatedTask.getName());
		assertEquals("Updated Description", updatedTask.getDescription());
	}
}
