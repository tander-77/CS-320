package appointmentService;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
	@Test
	public void testAppointmentCreation() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day ahead
		Appointment appointment = new Appointment("12345", futureDate, "Doctor's Appointment");
		assertEquals("12345", appointment.getAppointmentId());
		assertEquals(futureDate, appointment.getAppointmentDate());
		assertEquals("Doctor's Appointment", appointment.getDescription());
	}
	
	@Test
	public void testInvalidAppointment() {
		assertThrows(IllegalArgumentException.class, () -> new Appointment(null, new Date(), "Valid Description"));
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", new Date(), "Valid Description"));
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", null, "Valid Description"));
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", new Date(System.currentTimeMillis() - 86400000), "Valid Description")); // 1 day past
		assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", new Date(), null));
	}
	
	@Test
	public void testSetAppointmentDate() {
		Date futureDate1 = new Date(System.currentTimeMillis() + 86400000); // 1 day ahead
		Date futureDate2 = new Date(System.currentTimeMillis() + 86400000); // 1 day ahead
		Appointment appointment = new Appointment("12345", futureDate1, "Doctor's Visit");
		appointment.setAppointmentDate(futureDate2);
		assertEquals(futureDate2, appointment.getAppointmentDate());
	}
	
	@Test
	public void testSetDescription() {
		Date futureDate = new Date(System.currentTimeMillis() + 864000000); // 1 day ahead
		Appointment appointment = new Appointment("12345", futureDate, "Doctor's Visit");
		appointment.setDescription("Updated Description");
		assertEquals("Updated Description", appointment.getDescription());
	}
}
