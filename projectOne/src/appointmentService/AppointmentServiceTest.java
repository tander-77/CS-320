package appointmentService;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
	@Test
	public void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day ahead
		Appointment appointment = new Appointment("12345", futureDate, "Doctor's Appointment");
		service.addAppointment(appointment);
		assertEquals(appointment, service.getAppointmentById("12345"));
	}
	
	@Test
	public void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day ahead
		Appointment appointment = new Appointment("12345", futureDate, "Doctor's Appointment");
		service.addAppointment(appointment);
		service.deleteAppointment("12345");
		assertNull(service.getAppointmentById("12345"));
	}
	
	@Test
	public void testDeleteNonExistentAppointment() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("99999"));
	}
	
	@Test
	public void testDuplicateAppointmentId() {
		AppointmentService service = new AppointmentService();
		Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day ahead
		Appointment appointment1 = new Appointment("12345", futureDate, "Check-up");
		Appointment appointment2 = new Appointment("12345", futureDate, "Another Check-Up");
		service.addAppointment(appointment1);
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
	}
}
