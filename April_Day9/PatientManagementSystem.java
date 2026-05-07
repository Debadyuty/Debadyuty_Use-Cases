package April_Day9;
import java.util.ArrayList;
import java.util.Scanner;

// Patient class
class Patient {

    // Data members
    int id;
    String name;
    int age;
    String disease;

    // Constructor
    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    // Method to display patient details
    void displayPatient() {
        System.out.println("Patient ID : " + id);
        System.out.println("Patient Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Disease : " + disease);
        System.out.println("---------------------------");
    }
}

// Main class
public class PatientManagementSystem {

    public static void main(String[] args) {

        // Creating ArrayList to store patients
        ArrayList<Patient> patientList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== PATIENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient By Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:

                    // Taking patient details
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    // Creating object
                    Patient p = new Patient(id, name, age, disease);

                    // Adding object to ArrayList
                    patientList.add(p);

                    System.out.println("Patient Registered Successfully!");
                    break;

                case 2:

                    // Display all patients
                    if (patientList.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {

                        System.out.println("\nList of Patients:");

                        for (Patient patient : patientList) {
                            patient.displayPatient();
                        }
                    }

                    break;

                case 3:

                    // Search patient by name
                    System.out.print("Enter patient name to search: ");
                    String searchName = sc.nextLine();

                    boolean found = false;

                    for (Patient patient : patientList) {

                        if (patient.name.equalsIgnoreCase(searchName)) {

                            System.out.println("\nPatient Found:");
                            patient.displayPatient();

                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}



