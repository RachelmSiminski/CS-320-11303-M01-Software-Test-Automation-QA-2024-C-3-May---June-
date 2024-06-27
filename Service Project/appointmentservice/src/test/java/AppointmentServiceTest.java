import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	private AppointmentService appointmentService;
	
	private Date futureDate;
	private Date newFutureDate;
	
	@BeforeEach
	// Create dummy appointmentService to use for testing
	void setUpAppointmentService() {
		appointmentService = new AppointmentService();
		
		// Grab the current date
		Calendar calendar = Calendar.getInstance();
		// Set to one day in the future
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		// Declare 'futureDate' for creating dummy appointments
		futureDate = calendar.getTime();
		
		// Create and add a new appointment to appointmentList
		appointmentService.addAppointment(futureDate, "Test description.");
	}
	
	// Tests for ADD appointment
	@Test
	void testAddAppointmentPASS() {
		// Search for appointment
		Appointment testApptPASS = appointmentService.searchAppointmentList("1");
		
		// Test that appointment is added correctly
		assertNotNull(testApptPASS);
		// This test shows that the addAppointment() method is able to add a new appointment to the appointment list
	}
	
	@Test
	void testAddAppointmentDatePASS() {
		// Search for appointment
		Appointment testApptDatePASS = appointmentService.searchAppointmentList("1");
		
		// Test that appointment date is equal to futureDate
		assertEquals(testApptDatePASS.getAppointmentDate(), futureDate);
		// This test shows that the addAppointment() method has correctly populated the appointment date field
	}
	
	@Test
	void testAddAppointmentDescriptionPASS() {
		// Search for appointment
		Appointment testApptDescPASS = appointmentService.searchAppointmentList("1");
		
		// Test that appointment description is "Test description."
		assertEquals(testApptDescPASS.getAppointmentDesc(), "Test description.");
		
		// This test shows that addAppointment() has correctly populated the appointment description field
	}
	
	// Tests for UPDATE appointment
	public void prepUpdateAppointment() {
		// Update appointment
		appointmentService.updateAppointment("1");
		
		// Update appointment fields
		Appointment testAppt = appointmentService.searchAppointmentList("1");
		
		// Grab the current date
		Calendar calendar = Calendar.getInstance();
		// Set to five days in the future
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		// Declare 'newFutureDate' for testing updateAppointment()
		newFutureDate = calendar.getTime();
		
		testAppt.setAppointmentDate(newFutureDate);
		testAppt.setAppointmentDesc("New test description");
	}
	
	@Test
	void testUpdateAppointmentDatePASS() {
		// Search for appointment
		Appointment testUpdateApptDate = appointmentService.searchAppointmentList("1");
		
		// Test that appointment date has updated
		assertEquals(testUpdateApptDate.getAppointmentDate(), newFutureDate);
		
		// This test shows that the updateAppointment() method has correctly updated the appointment date field
	}
	
	@Test
	void testUpdateAppointmentDescriptionPASS() {
		// Search for appointment
		Appointment testUpdateApptDesc = appointmentService.searchAppointmentList("1");
		
		// Test that appointment description has updated
		assertEquals(testUpdateApptDesc.getAppointmentDesc(), "New test description.");
		
		// This test shows that the updateAppointment() method has correctly updated the appointment description
	}
	
	
	// Tests for DELETE appointment
	@Test
	void testDeleteAppointmentPASS() {
		// Delete appointment
		appointmentService.deleteAppointment("1");
		
		// Search for appointment
		Appointment testDeleteAppt = appointmentService.searchAppointmentList("1");
		
		// Test that appointment is deleted (null)
		assertNull(testDeleteAppt);
		
		// This test shows that the deleteAppointment() method has successfully deleted the appointment from the application
	}
	
}