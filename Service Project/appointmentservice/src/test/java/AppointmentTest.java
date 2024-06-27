/*
 * AppointmentTest.java
 * 
 * JUnit tests for Appointment.java functionality.
 * These test will verify that the appointment object is being
 *  created properly.
*/

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentTest {
	
	// Test passing appointments
	private Appointment apptPASS;
	private Appointment apptUniqueIdPASS;
	
	// Adjusted dates for testing
	private Date futureDate;
	private Date pastDate;
	
	@BeforeEach
	void setUp() {
		// Grab the current date
		Calendar calendar = Calendar.getInstance();
		// Set to one day in the future
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		// Declare 'futureDate' for creating dummy appointments
		futureDate = calendar.getTime();
		
		// Reset to the current date
		calendar = Calendar.getInstance();
		// Repeat, but one year in the past
		calendar.add(Calendar.YEAR, -1);
		// Declare 'pastDate'
		pastDate = calendar.getTime();
		
		// Create dummy appointments to use for testing
		apptPASS = new Appointment(futureDate, "Test description 1.");
		apptUniqueIdPASS = new Appointment(futureDate, "Test description 2.");
		
	}
	
	// Tests for AppointmentIdNum
	@Test
	void testAppointmentIdNumberNotNull() {
		assertNotNull(apptPASS.getAppointmentIdNumber());
		// This test shows that an ID number is being generated for the appointment
	}
	
	@Test
	void testAppointmentIdNumberUnique() {
		assertNotEquals(apptPASS.getAppointmentIdNumber(), apptUniqueIdPASS.getAppointmentIdNumber());
		// This test shows that each appointment has a unique ID number
	}
	
	@Test
	void testAppointmentIdNumberNotExceed10Char() {
		assertTrue(apptPASS.getAppointmentIdNumber().length() <= 10);
		// This test shows that the ID number generated is not exceeding 10 characters
	}
	
	
	// Tests for appointmentDate
	@Test
	void testAppointmentDateNotNullPASS() {
		assertNotNull(apptPASS.getAppointmentDate());
		// This test shows that the appointment date is not null
	}
	
	@Test
	void testAppointmentDateNotNullEXCEPTION() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, "Test description 3.");
        });
		// This test shows that the system will not allow a null date
	}
	
	@Test
	void testAppointmentDateNotInPastPASS() {
		assertTrue(apptPASS.getAppointmentDate().after(Calendar.getInstance().getTime()));
		// This test shows that the appointment date is not in the past
	}
	
	@Test
	void testAppointmentDateNotInPastEXCEPTION() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(pastDate, "Test description 4.");
        });
		// This test shows that the system will not allow a past date
	}
	
	// Tests for appointmentDesc
	@Test
	void testAppointmentDescriptionNotNullPASS() {
		assertNotNull(apptPASS.getAppointmentDesc());
		// This test shows that the appointment description is not null
	}
	
	@Test
	void testAppointmentDescriptionNotNullEXCEPTION() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(futureDate, null);
        });
		// This test shows that the application won't allow a null appointment description
	}
	
	@Test
	void testAppointmentDescriptionNotExceed50CharPASS() {
		assertTrue(apptPASS.getAppointmentDesc().length() <= 50);
		// This test shows that the appointment description doesn't exceed 50 characters
	}
	
	@Test
	void testAppointmentDescriptionNotExceed50CharEXCEPTION() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(futureDate, "Test description 4. This description is too long, oh well.");
        });
		// This test shows that the application won't allow an appointment description longer than 50 characters
	}
}