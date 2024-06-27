public class Contact{
	private static int contactCount = 0;
	private final String contactIdNumber;
	private String contactFirstName;
	private String contactLastName;
	private String phoneNumber;
	private String homeAddress;
	
	
	//Contact Constructor
	public Contact(String firstName, String lastName, String phoneNumber, String homeAddress) {
		this.contactIdNumber = generateContactId();
		
		// Validate and set first name
        if (firstName != null && firstName.length() <= 10) {
            this.contactFirstName = firstName;
        } 
        else {
            throw new IllegalArgumentException("First name must not be null and cannot exceed 10 characters.");
        }

        // Validate and set last name
        if (lastName != null && lastName.length() <= 10) {
            this.contactLastName = lastName;
        } 
        else {
            throw new IllegalArgumentException("Last name must not be null and cannot exceed 10 characters.");
        }

        // Validate and set phone number
        if (phoneNumber != null && phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        } 
        else {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }

        // Validate and set home address
        if (homeAddress != null && homeAddress.length() <= 30) {
            this.homeAddress = homeAddress;
        } 
        else {
            throw new IllegalArgumentException("Home address must not be null and cannot exceed 30 characters.");
        }
	}
	
	//ContactID getter
	public String getContactIdNumber() {
		return contactIdNumber;
	}
	
	//FirstName getter
	public String getContactFirstName() {
		return contactFirstName;
	}
	
	//FirstName setter
	public void setContactFirstName(String newFirstName) {
		this.contactFirstName = newFirstName;
	}
	
	//LastName getter
	public String getContactLastName() {
		return contactLastName;
	}
	
	//LastName setter
	public void setContactLastName(String newLastName) {
		this.contactLastName = newLastName;
	}
	
	//PhoneNumber getter
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	//PhoneNumber setter
	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}
	
	//HomeAddress getter
	public String getHomeAddress() {
		return homeAddress;
	}
	
	//HomeAddress setter
	public void setHomeAddress(String newHomeAddress) {
		this.homeAddress = newHomeAddress;
	}
	
	//ContactID generator
	private static String generateContactId() {
		String genContactID = String.valueOf(++contactCount);
		if (genContactID.length() > 10) {
	        throw new IllegalStateException("Generated contact ID exceeds 10 characters.");
	    }
		else {
			return genContactID;
		}
	}
	
}