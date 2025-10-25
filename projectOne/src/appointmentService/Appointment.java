package appointmentService;

import java.util.Date;

public class Appointment {
	private final String appointmentId;
	private Date appointmentDate;
	private String description;
	
	public Appointment(String appointmentId, Date appointmentDate, String description) {
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment Date Cannot Be In The Past");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment Date Cannot Be In The Past");
		}
		this.appointmentDate = appointmentDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		this.description = description;
	}
}
