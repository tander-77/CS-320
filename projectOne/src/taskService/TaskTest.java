package taskService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
	@Test
	public void testTaskCreation() {
		Task task = new Task("12345", "Task Name", "Task Description");
		assertEquals("12345", task.getTaskId());
		assertEquals("Task Name", task.getName());
		assertEquals("Task Description", task.getDescription());
	}
	
	@Test
	public void testInvalidTask() {
		assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Name", "Task Description"));
		assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task Name", "Task Description"));
		assertThrows(IllegalArgumentException.class, () -> new Task("12345", null, "Task Description"));
		assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Task Name", null));
	}
}
