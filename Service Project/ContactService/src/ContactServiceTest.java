import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ContactServiceTest {

	private ContactService contactService;
	
	@BeforeEach
	// Instantiate a new contactService object before each test
	public void testPrep() {
		contactService = new ContactService();
	}
	
	@Test
	// Test add contact functionality
	public void testAddContact() {
		// Create and add new contact to contactList
		contactService.addContact("Atticus", "G.S.", "111111111", "1234 Asdfg St");
		// Search for new contact
		Contact testContact = contactService.searchContactList("1");
		
		// Use test contact to compare data fields
		assertNotNull(testContact);
		assertEquals("John", testContact.getContactFirstName());
		assertEquals("Doe", testContact.getContactLastName());
		assertEquals("1234567890", testContact.getPhoneNumber());
		assertEquals("123 Main St", testContact.getHomeAddress());
	}
	
	@Test
	// Test search contact functionality
	public void testSearchContact() {
		// Create and add new contact to contactList
		contactService.addContact("Atticus", "G.S.", "111111111", "1234 Asdfg St");
		
		// Test search for new contact
		Contact testContactPass = contactService.searchContactList("1");
		assertNotNull(testContactPass);
		
		// Test search for non-existent contact
		Contact testContactFail = contactService.searchContactList("100");
		assertNull(testContactFail);
	}
	
	@Test
	// Test update contact functionality
	public void testUpdateContact() {
		// Create and add new contact to contactList
		contactService.addContact("Atticus", "G.S.", "111111111", "1234 Asdfg St");
		contactService.updateContact("1");
		
		// Update contact fields
		Contact testContact = contactService.searchContactList("1");
		
		testContact.setContactFirstName("Meme");
		testContact.setContactLastName("Gamas");
		testContact.setPhoneNumber("1234567890");
		testContact.setHomeAddress("0987 Poiuyt Rd");
		
		// Test that fields are updated
		// First Name
		assertNotEquals("Atticus", testContact.getContactFirstName());
		assertEquals("Meme", testContact.getContactFirstName());
		
		// Last name
		assertNotEquals("G.S.", testContact.getContactLastName());
		assertEquals("Gamas", testContact.getContactLastName());
		
		// Phone Number
		assertNotEquals("1111111111", testContact.getPhoneNumber());
		assertEquals("1234567890", testContact.getPhoneNumber());
		
		// Home Address
		assertNotEquals("1234 Asdfg St", testContact.getHomeAddress());
		assertEquals("0987 Poiuyt Rd", testContact.getHomeAddress());
	}
	
	@Test
	// Test delete contact functionality
	public void testDeleteContact() {
		// Create and add new contact to contactList
		contactService.addContact("Atticus", "G.S.", "111111111", "1234 Asdfg St");
		contactService.deleteContact("1");
		
		// Test that deleted contact now shows as null
		Contact testContact = contactService.searchContactList("1");
		assertNull(testContact);
		
		// Test delete non-existent contact
		contactService.deleteContact("100");
		assertNull(testContact);
	}
}
