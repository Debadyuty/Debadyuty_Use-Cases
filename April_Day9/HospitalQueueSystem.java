package April_Day9;
import java.util.LinkedList;
import java.util.Scanner;

// Patient class
class Patient {

    int id;
    String name;
    String disease;

    // Constructor
    Patient(int id, String name, String disease) {
        this.id = id;
        this.name = name;
        this.disease = disease;
    }

    // Method to display patient details
    void displayPatient() {
        System.out.println("Patient ID : " + id);
        System.out.println("Patient Name : " + name);
        System.out.println("Disease : " + disease);
        System.out.println("--------------------------");
    }
}

// Main class
public class HospitalQueueSystem {

    public static void main(String[] args) {

        // Creating LinkedList
        LinkedList<Patient> patientQueue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== HOSPITAL QUEUE SYSTEM =====");
            System.out.println("1. Add Normal Patient");
            System.out.println("2. Add Emergency Patient");
            System.out.println("3. Remove First Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. View First Patient");
            System.out.println("6. View Last Patient");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    // Add normal patient at end
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    Patient normalPatient = new Patient(id, name, disease);

                    // addLast() adds at end
                    patientQueue.addLast(normalPatient);

                    System.out.println("Normal Patient Added.");
                    break;

                case 2:

                    // Add emergency patient at beginning
                    System.out.print("Enter Patient ID: ");
                    int eid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String ename = sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String edisease = sc.nextLine();

                    Patient emergencyPatient =
                            new Patient(eid, ename, edisease);

                    // addFirst() adds at beginning
                    patientQueue.addFirst(emergencyPatient);

                    System.out.println("Emergency Patient Added at Beginning.");
                    break;

                case 3:

                    // Remove first patient
                    if (patientQueue.isEmpty()) {

                        System.out.println("Queue is empty.");

                    } else {

                        Patient removedPatient = patientQueue.removeFirst();

                        System.out.println("Removed Patient:");
                        removedPatient.displayPatient();
                    }

                    break;

                case 4:

                    // View all patients
                    if (patientQueue.isEmpty()) {

                        System.out.println("No patients in queue.");

                    } else {

                        System.out.println("\nPatients in Queue:");

                        for (Patient p : patientQueue) {
                            p.displayPatient();
                        }
                    }

                    break;

                case 5:

                    // View first patient
                    if (patientQueue.isEmpty()) {

                        System.out.println("Queue is empty.");
} else {

                        System.out.println("First Patient in Queue:");
                        patientQueue.getFirst().displayPatient();
                    }

                    break;

                case 6:

                    // View last patient
                    if (patientQueue.isEmpty()) {

                        System.out.println("Queue is empty.");

                    } else {

                        System.out.println("Last Patient in Queue:");
                        patientQueue.getLast().displayPatient();
                    }

                    break;

                case 7:

                    System.out.println("Exiting Program...");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
