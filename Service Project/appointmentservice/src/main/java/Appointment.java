import java.util.Date;
import java.text.SimpleDateFormat;

public class Appointment {
	private static int appointmentCount = 0;
	private final String appointmentIdNum;
	private Date appointmentDate;
	private String appointmentDesc;
	
	
	// Appointment Constructor
	public Appointment(Date date, String desc) {
		this.appointmentIdNum = generateAppointmentId();
		
		// Validate and set appointment date
        if (date != null && !date.before(new Date())) {
            this.appointmentDate = date;
        } 
        else {
            throw new IllegalArgumentException("Date must not be null or in the past.");
        }

        // Validate and set appointment description
        if (desc != null && desc.length() <= 50) {
            this.appointmentDesc = desc;
        } 
        else {
            throw new IllegalArgumentException("Appointment description must not be null and cannot exceed 50 characters.");
        }
	}
	
	// AppointmentID getter
	public String getAppointmentIdNumber() {
		return appointmentIdNum;
	}
	
	// Appointment Date getter
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	// Appointment Date setter
	public void setAppointmentDate(Date newAppointmentDate) {
		if (newAppointmentDate != null && !newAppointmentDate.before(new Date())) {
			this.appointmentDate = newAppointmentDate;
		}
		else {
			throw new IllegalArgumentException("Appointment date must not be in the past.");
		}
	}
	
	// Appointment Description getter
	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	
	// Appointment Description setter
	public void setAppointmentDesc(String newAppointmentDesc) {
		if (newAppointmentDesc != null && newAppointmentDesc.length() <= 50) {
			this.appointmentDesc = newAppointmentDesc;
		}
		else {
			throw new IllegalArgumentException("Appointment description must not be null and cannot exceed 50 characters.");
		}
	}
	
	// Appointment ID generator
	private static synchronized String generateAppointmentId() {
		String genAppointmentIdNum = String.valueOf(++appointmentCount);
		if (genAppointmentIdNum.length() > 10) {
	        throw new IllegalStateException("Generated appointment ID exceeds 10 characters.");
	    }
		else {
			return genAppointmentIdNum;
		}
	}
}