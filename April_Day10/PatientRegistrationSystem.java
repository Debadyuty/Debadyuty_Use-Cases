package April_Day10;
import java.util.TreeSet;
import java.util.Scanner;

public class PatientRegistrationSystem {
	 private TreeSet<String> patientIds;

	    // Constructor
	    public PatientRegistrationSystem() {
	        patientIds = new TreeSet<>();
	    }

	    // Method to register patient
	    public void registerPatient(String id) {
	        if (patientIds.contains(id)) {
	            System.out.println("ID already registered");
	        } else {
	            patientIds.add(id);
	            System.out.println("Patient added to the system");
	        }
	    }

	    // Method to display all patients
	    public void displayPatients() {
	        if (patientIds.isEmpty()) {
	            System.out.println("No patients registered");
	        } else {
	            System.out.println("List of unique registered patients:");
	            for (String id : patientIds) {
	                System.out.println(id);
	            }
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        PatientRegistrationSystem system = new PatientRegistrationSystem();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n1. Register Patient");
	            System.out.println("2. View Patients");
	            System.out.println("3. Exit");
	            System.out.print("Enter choice: ");

	            int choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Patient ID: ");
	                    String id = sc.nextLine();
	                    system.registerPatient(id);
	                    break;

	                case 2:
	                    system.displayPatients();
	                    break;

	                case 3:
	                    System.out.println("Exiting...");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }
	}


