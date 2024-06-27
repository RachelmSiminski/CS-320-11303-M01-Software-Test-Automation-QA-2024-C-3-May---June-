import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	// Tests for ContactID
	public void testContactId() {
		// Create two dummy contacts to use for testing
		Contact testContact1 = new Contact("Rachel", "Siminski", "1111111111", "123 Asdf St");
		Contact testContact2 = new Contact("Emmanuel", "Gamas", "2222222222", "4567 Qwerty Rd");
		
		// Test that the application is generating and assigning an ID for each contact
		assertNotNull(testContact1.getContactIdNumber());
		assertNotNull(testContact2.getContactIdNumber());
		
		// Test that the application is generating a unique ID for each contact
		assertNotEquals(testContact1.getContactIdNumber(), testContact2.getContactIdNumber());
		
		// Test that the ID number does not exceed the maximum allowed 10 characters
		assertTrue(testContact1.getContactIdNumber().length() <= 10);
		assertTrue(testContact2.getContactIdNumber().length() <= 10);
	}
	
	@Test
	// Tests for First Name
	public void testFirstName() {
		// Create three dummy contacts to use for testing
		Contact testContactPass = new Contact("Rachel", "Siminski", "1111111111", "123 Asdf St");
		Contact testContactFailNull = new Contact(null, "Gamas", "2222222222", "4567 Qwerty Rd");
		Contact testContactFailLength = new Contact("Atticusssss", "G.S.", "3333333333", "8910 Zxcvb Dr");
		
		// Test that the first name is not null
		assertNotNull(testContactPass.getContactFirstName());
		assertNotNull(testContactFailNull.getContactFirstName());
		assertNotNull(testContactFailLength.getContactFirstName());
		
		// Test that the first name does not exceed the maximum allowed 10 characters
		assertTrue(testContactPass.getContactFirstName().length() <= 10);
		assertTrue(testContactFailNull.getContactFirstName().length() <= 10);
		assertTrue(testContactFailLength.getContactFirstName().length() <= 10);
	}

	@Test
	// Tests for Last Name
	public void testLastName() {
		// Create three dummy contacts to use for testing
		Contact testContactPass = new Contact("Rachel", "Siminski", "1111111111", "123 Asdf St");
		Contact testContactFailNull = new Contact("Meme", null, "2222222222", "4567 Qwerty Rd");
		Contact testContactFailLength = new Contact("Atticus", "Gamas Siminski", "3333333333", "8910 Zxcvb Dr");
		
		// Test that the last name is not null
		assertNotNull(testContactPass.getContactLastName());
		assertNotNull(testContactFailNull.getContactLastName());
		assertNotNull(testContactFailLength.getContactLastName());
		
		// Test that the last name does not exceed the maximum allowed 10 characters
		assertTrue(testContactPass.getContactLastName().length() <= 10);
		assertTrue(testContactFailNull.getContactLastName().length() <= 10);
		assertTrue(testContactFailLength.getContactLastName().length() <= 10);
	}
	
	@Test
	// Test for Phone Number
	public void testPhoneNumber() {
		//Create three dummy contacts to use for testing
		Contact testContactPass = new Contact("Rachel", "Siminski", "1111111111", "123 Asdf St");
		Contact testContactFailNull = new Contact("Meme", "Gamas", null, "4567 Qwerty Rd");
		Contact testContactFailLength = new Contact("Atticus", "Gamas Siminski", "3", "8910 Zxcvb Dr");
		
		// Test that the phone number is not null
		assertNotNull(testContactPass.getPhoneNumber());
		assertNotNull(testContactFailNull.getPhoneNumber());
		assertNotNull(testContactFailLength.getPhoneNumber());
		
		// Test that the phone number adheres to expected 10 character format
		assertTrue(testContactPass.getPhoneNumber().length() <= 10);
		assertTrue(testContactFailNull.getPhoneNumber().length() <= 10);
		assertTrue(testContactFailLength.getPhoneNumber().length() <= 10);
	}
	
	@Test
	// Test for Home Address
	public void testHomeAddress() {
		//Create three dummy contacts to use for testing
		Contact testContactPass = new Contact("Rachel", "Siminski", "1111111111", "123 Asdf St");
		Contact testContactFailNull = new Contact("Meme", "Gamas", "2222222222", null);
		Contact testContactFailLength = new Contact("Atticus", "Gamas Siminski", "3333333333", "891011 Zxcvbnm Qazwsx Edcrfv Dr");
			
		// Test that the home address is not null
		assertNotNull(testContactPass.getHomeAddress());
		assertNotNull(testContactFailNull.getHomeAddress());
		assertNotNull(testContactFailLength.getHomeAddress());
				
		// Test that the home address does not exceed the maximum allowed 30 characters
		assertTrue(testContactPass.getHomeAddress().length() <= 30);
		assertTrue(testContactFailNull.getHomeAddress().length() <= 30);
		assertTrue(testContactFailLength.getHomeAddress().length() <= 30);
	}
}
