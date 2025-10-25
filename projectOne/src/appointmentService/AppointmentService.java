package appointmentService;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	public void addAppointment(Appointment appointment) {
		if (appointments.containsKey(appointment.getAppointmentId())) {
			throw new IllegalArgumentException("Appointment ID Already Exists");
		}
		appointments.put(appointment.getAppointmentId(), appointment);
	}
	
	public void deleteAppointment(String appointmentId) {
		if (!appointments.containsKey(appointmentId)) {
			throw new IllegalArgumentException("Appointment ID Does Not Exist");
		}
		appointments.remove(appointmentId);
	}
	
	public Appointment getAppointmentById(String appointmentId) {
		return appointments.get(appointmentId);
	}
}
