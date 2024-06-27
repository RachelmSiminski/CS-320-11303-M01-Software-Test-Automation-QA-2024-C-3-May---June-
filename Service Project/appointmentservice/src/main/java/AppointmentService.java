/* Developer: Rachel Siminski 
 * Date: 6/11/2024
 * Title: AppointmentService
 * 
 * 
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


public class AppointmentService {
	// Declare and initialize Appointment List ArrayList
    private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

	// Convert string input to date
    public static Date parseDate(Scanner scanner) {
    	// Initialize month, day, and year variables
        int month = 0;
        int day = 0;
        int year = 0;
        
        // Determine current date
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        
        while(true) {
        	try {
        		System.out.println("Enter year (YYYY): ");
                year = scanner.nextInt();
                
                if (year < currentYear) {
                	throw new NumberFormatException();
                }
                
                break; // if year is valid, exit loop
        	}
        	catch (NumberFormatException e) {
        		System.out.println("Invalid year. Date cannot be in the past.");
        	}
        }
        
        while (true) {
            try {
                System.out.println("Enter month (MM): ");
                month = scanner.nextInt();

                if (month < 0 || month > 12) {
                    throw new NumberFormatException();
                }
                else if (year == currentYear) {
                	if (month < currentMonth) {
                		throw new NumberFormatException();
                	}
                }

                break; // if month is valid, exit loop
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid month. Date cannot be in the past.");
            }
        }

        while (true) {
            try {
                System.out.println("Enter day (DD): ");
                day = scanner.nextInt();
                
                // Validate day based on month and year
                if (year == currentYear && month == currentMonth) {
                	if (day < currentDay) {
                		throw new NumberFormatException();
                	}
                }
                else if (month == 2) { // February
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        // Leap year, February has 29 days
                        if (day < 1 || day > 29) {
                            throw new NumberFormatException();
                        }
                    } 
                    else {
                        // Non-leap year, February has 28 days
                        if (day < 1 || day > 28) {
                            throw new NumberFormatException();
                        }
                    }
                } 
                else if (month == 4 || month == 6 || month == 9 || month == 11) { // April, June, September, November
                    if (day < 1 || day > 30) {
                        throw new NumberFormatException();
                    }
                } 
                else { // January, March, May, July, August, October, December
                    if (day < 1 || day > 31) {
                        throw new NumberFormatException();
                    }
                }

                break; // if day is valid exit loop
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid day. Please enter a day according to the selected month and year.");
            }
        }

        scanner.nextLine(); // Consume newline

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }
    
    // Format date to MM/DD/YYYY
    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(date);
    }
    
    // Add appointment to Appointment List
    public void addAppointment(Date date, String desc) {
        Appointment newAppointment = new Appointment(date, desc);
        appointmentList.add(newAppointment);
    }

    // Search appointment list for given appointment ID
    public Appointment searchAppointmentList(String appointmentIdNum) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentIdNumber().equalsIgnoreCase(appointmentIdNum)) {
                return appointment;
            }
        }
        return null; // Return null if no appointment is found with the given ID
    }
    
    // Update appointment in Appointment List
    public void updateAppointment(String appointmentIdNum) {
    	Appointment appointmentToUpdate = searchAppointmentList(appointmentIdNum);
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
    	
    	int choice = 0;
    	
    	if (appointmentToUpdate != null) {
    		do {
    			System.out.println("Please select which field you would like to update: ");
    			System.out.println("1. Appointment date");
    			System.out.println("2. Appointment description");
    			System.out.println("9. Return to main menu");
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
    					System.out.println("Please enter the new appointment date: ");
    					Date newAppointmentDate = parseDate(scanner);
    					
    					try {
    						appointmentToUpdate.setAppointmentDate(newAppointmentDate);
    					}
    					catch (IllegalArgumentException e) {
    						System.out.println("Unable to update appointment date: " + e.getMessage());
    					}
    					break;
    					
    				case 2:
    					System.out.println("Please enter the new appointment description: ");
    					String newAppointmentDesc = scanner.nextLine();
    					
    					try {
    						appointmentToUpdate.setAppointmentDesc(newAppointmentDesc);
    					}
    					catch (IllegalArgumentException e) {
    						System.out.println("Unable to update appointment description: " + e.getMessage());
    					}
    					break;
    					
    				case 9:
    					break;
    					
    				default:
    					System.out.println("Invalid input. Please select from the listed choices.");
    			}
    			
    			System.out.println("ID: " + appointmentToUpdate.getAppointmentIdNumber());
    			System.out.println("Appointment Date: " + formatDate(appointmentToUpdate.getAppointmentDate()));
    			System.out.println("Appointment Description: " + appointmentToUpdate.getAppointmentDesc());
    			System.out.println();
    			
    		} 
    		while (choice !=9);
    	}
    }
    
    // Delete appointment from Appointment List
    public void deleteAppointment(String appointmentIdNum) {
        Appointment appointmentToDelete = searchAppointmentList(appointmentIdNum);
        if (appointmentToDelete != null) {
            appointmentList.remove(appointmentToDelete);
            System.out.println("Appointment deleted successfully.");
        } 
        else {
            System.out.println("Appointment not found.");
        }
    }
    
    // Display appointment list
    public void displayAppointmentList() {
    	System.out.println("   APPOINTMENTS   ");
    	for (Appointment appointment: appointmentList) {
    		System.out.println("Appointment ID: " + appointment.getAppointmentIdNumber());
    		System.out.println("Appointment Date: " + formatDate(appointment.getAppointmentDate()));
    		System.out.println("Appointment Description: " + appointment.getAppointmentDesc());
    		System.out.println();
    	}
    }
	
	public static void main(String[] args) {
		// Create new instance of Appointment Service
		AppointmentService appointmentService = new AppointmentService();
		Scanner scanner = new Scanner(System.in);
    	
    	int choice = 0;
    	
    	do {
    		System.out.println("  Main Menu  ");
    		System.out.println("Please select from an option below.");
    		System.out.println("1. Create new appointment");
    		System.out.println("2. Update appointment");
    		System.out.println("3. Delete appointment");
    		System.out.println("4. Display appointments");
    		System.out.println("9. Exit");
    		System.out.println();
    			
    		if (scanner.hasNextInt()) {
    			choice = scanner.nextInt();
    			scanner.nextLine(); // Consume newline input
    			
    			switch (choice) {
    			// Create new appointment
    			case 1:
    				System.out.println("Please enter the following information: ");
    				System.out.println("Appointment date:");
    				Date date = parseDate(scanner);
    				
    				System.out.println("Appointment description:");
    				String desc = scanner.nextLine();
    				
    				try {
    					appointmentService.addAppointment(date, desc);
    					System.out.println("Appointment added successfully!");
    				} 
    				catch (IllegalArgumentException e) {
    					System.out.println("Unable to add appointment: " + e.getMessage());
    				}
    				break;
    				
    			// Update appointment
    			case 2:
    				System.out.println("Please enter the ID number for the appointment you would like to update:");
    				String appointmentIdNum = scanner.nextLine();
    				
    				appointmentService.updateAppointment(appointmentIdNum);
    				break;
    				
    			// Delete appointment
    			case 3:
    				System.out.println("Please enter the ID for the appointment you would like to delete:");
    				String appointmentDelete = scanner.nextLine();
    				
    				appointmentService.deleteAppointment(appointmentDelete);
    				break;
    				
    			// Display appointments
    			case 4:
    				appointmentService.displayAppointmentList();
    				break;
    			
    			// Exit application
    			case 9:
    				System.out.println("Goodbye.");
    				break;
    			// Default
    			default:
    				System.out.println("Invalid input. Please select from the menu options above.");
    				break;
    			}
    		} 
    	}
    	while (choice !=9);
    		
    	scanner.close();
	}
}