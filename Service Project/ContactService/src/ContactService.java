import java.util.ArrayList;
import java.util.Scanner;


public class ContactService {
	// Declare and initialize Contact List ArrayList
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    // Add contact to Contact List
    public void addContact(String firstName, String lastName, String phoneNumber, String homeAddress) {
        Contact newContact = new Contact(firstName, lastName, phoneNumber, homeAddress);
        contactList.add(newContact);
    }

    // Search contact list for given contact ID
    public Contact searchContactList(String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactIdNumber().equalsIgnoreCase(contactID)) {
                return contact;
            }
        }
        return null; // Return null if no contact is found with the given ID
    }
    
    // Update contact in Contact List
    public void updateContact(String contactID) {
    	Contact contactToUpdate = searchContactList(contactID);
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
    	
    	int choice = 0;
    	
    	if (contactToUpdate != null) {
    		do {
    			System.out.println("Please select which field you would like to update: ");
    			System.out.println("1. First name");
    			System.out.println("2. Last name");
    			System.out.println("3. Phone number");
    			System.out.println("4. Home address");
    			System.out.println("9. Back");
    			System.out.println();
    			
    			if (scanner.hasNextInt()) {
    				choice = scanner.nextInt();
    				scanner.nextLine();
    			}
    			else {
    				scanner.nextLine();
    				System.out.println("Invalid input. Please enter a number.");
    				choice = 0;
    			}
    			
    			switch (choice) {
    				case 1:
    					System.out.println("Please enter the new first name: ");
    					String newFirstName = scanner.next();
    					
    					contactToUpdate.setContactFirstName(newFirstName);
    					break;
    				case 2:
    					System.out.println("Please enter the new last name: ");
    					String newLastName = scanner.next();
    					
    					contactToUpdate.setContactLastName(newLastName);
    					break;
    				case 3:
    					System.out.println("Please enter the new phone number: ");
    					String newPhoneNumber = scanner.next();
    					
    					contactToUpdate.setPhoneNumber(newPhoneNumber);
    					break;
    				case 4:
    					System.out.println("Please enter the new home address: ");
    					String newHomeAddress = scanner.next();
    					
    					contactToUpdate.setHomeAddress(newHomeAddress);
    					break;
    				case 9:
    					break;
    				default:
    					System.out.println("Invalid input. Please select from the listed choices.");
    			}
    			
    			System.out.println("ID: " + contactToUpdate.getContactIdNumber());
    			System.out.println("First Name: " + contactToUpdate.getContactFirstName());
    			System.out.println("Last Name: " + contactToUpdate.getContactLastName());
    			System.out.println("Phone Number: " + contactToUpdate.getPhoneNumber());
    			System.out.println("Home Address: " + contactToUpdate.getHomeAddress());
    			System.out.println();
    			
    		} 
    		while (choice !=9);
    	}
    }
    
    // Delete contact from Contact List
    public void deleteContact(String contactID) {
        Contact contactToDelete = searchContactList(contactID);
        if (contactToDelete != null) {
            contactList.remove(contactToDelete);
            System.out.println("Contact deleted successfully.");
        } 
        else {
            System.out.println("Contact not found.");
        }
    }
	
	public static void main(String[] args) {
		// Create new instance of Contact Service
		ContactService contactService = new ContactService();
		Scanner scanner = new Scanner(System.in);
    	
    	int choice = 0;
    	
    	do {
    		System.out.println("  Main Menu  ");
    		System.out.println("Please select from an option below.");
    		System.out.println("1. Create new contact");
    		System.out.println("2. Update existing contact");
    		System.out.println("3. Delete contact");
    		System.out.println("4. Display contacts");
    		System.out.println("9. Exit");
    		System.out.println();
    			
    		if (scanner.hasNextInt()) {
    			choice = scanner.nextInt();
    			
    			switch (choice) {
    			// Create new contact
    			case 1:
    				System.out.println("Please enter the following information: ");
    				System.out.println("First name:");
    				String firstName = scanner.next();
    				
    				System.out.println("Last name:");
    				String lastName = scanner.next();
    				
    				System.out.println("Phone number:");
    				String phoneNumber = scanner.next();
    				
    				System.out.println("Home address:");
    				String homeAddress = scanner.next();
    				
    				try {
    					contactService.addContact(firstName, lastName, phoneNumber, homeAddress);
    					System.out.println("Contact added successfully!");
    				} 
    				catch (IllegalArgumentException e) {
    					System.out.println("Unable to add contact: " + e.getMessage());
    				}
    				break;
    				
    			// Update contact
    			case 2:
    				System.out.println("Please enter the ID number for the contact you would like to update:");
    				String contactID = scanner.next();
    				
    				contactService.updateContact(contactID);
    				break;
    				
    			// Delete contact
    			case 3:
    				System.out.println("Please enter the ID for the contact you would like to delete:");
    				
    				contactService.deleteContact(scanner.next());
    				break;
    				
    			// Display contacts
    			case 4:
    				System.out.print("Please enter the ID for the contact you would like to display");
    				System.out.println(" or enter 'all' to print the entire list.");
    				
    				if (scanner.next().equalsIgnoreCase("all")) {
    					for (Contact contact : contactService.contactList) {
    						System.out.println("Contact ID: " + contact.getContactIdNumber());
    						System.out.println("First Name: " + contact.getContactFirstName());
    						System.out.println("Last Name: " + contact.getContactLastName());
    						System.out.println("Phone Number: " + contact.getPhoneNumber());
    						System.out.println("Home Address: " + contact.getHomeAddress());
    						System.out.println();
    					}
    				}
    				else {
    					try {
    						Contact contact = contactService.searchContactList(scanner.next());
    						if (contact != null) {
    							System.out.println("Contact ID: " + contact.getContactIdNumber());
        						System.out.println("First Name: " + contact.getContactFirstName());
        						System.out.println("Last Name: " + contact.getContactLastName());
        						System.out.println("Phone Number: " + contact.getPhoneNumber());
        						System.out.println("Home Address: " + contact.getHomeAddress());
        						System.out.println();
    						}
    						else {
    							System.out.println("Unable to find contact.");
    						}
    					} 
    					catch (IllegalArgumentException e) {
    						System.out.println("Error: " + e.getMessage());
    					}
    				}
    				break;
    			case 9:
    				System.out.println("Exiting Contact Service.");
    				break;
    			default:
    				System.out.println("Invalid input. Please select from the listed choices.");
    			}
    			
    			scanner.nextLine(); // Consume newline character
    		}
    		
    		else {
    			scanner.nextLine(); // Consume invalid input
    			System.out.println("Invalid input. Please enter a number.");
    			choice = 0; // Reset choice to trigger re-display of menu
    		}
   			
   			System.out.println();
   		
    	} 
    	while (choice !=9);
    		
    	scanner.close();
	}
}