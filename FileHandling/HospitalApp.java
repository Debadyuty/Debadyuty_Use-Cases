package FileHandling;
import java.io.*;
import java.util.*;

public class HospitalApp {

    static final String PATIENT_FILE = "patients.txt";
    static final String REPORT_FILE = "reports.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== HOSPITAL MANAGEMENT ====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Medical Report");
            System.out.println("4. View Reports");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    addReport(sc);
                    break;
                case 4:
                    viewReports();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 🔹 Add Patient
    public static void addPatient(Scanner sc) {
        try {
            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();

            FileWriter writer = new FileWriter(PATIENT_FILE, true);
            writer.write(id + "," + name + "," + age + "," + disease + "\n");
            writer.close();

            System.out.println("Patient added successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 View Patients
    public static void viewPatients() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATIENT_FILE));
            String line;

            System.out.println("\n--- Patient List ---");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("ID: " + data[0]);
                System.out.println("Name: " + data[1]);
                System.out.println("Age: " + data[2]);
                System.out.println("Disease: " + data[3]);
                System.out.println("-------------------");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 Add Medical Report
    public static void addReport(Scanner sc) {
        try {
            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Diagnosis: ");
            String diagnosis = sc.nextLine();

            System.out.print("Enter Prescription: ");
            String prescription = sc.nextLine();

            String date = new Date().toString();

            FileWriter writer = new FileWriter(REPORT_FILE, true);
            writer.write(id + "," + diagnosis + "," + prescription + "," + date + "\n");
            writer.close();

            System.out.println("Medical report added!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 View Reports
    public static void viewReports() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(REPORT_FILE));
            String line;

            System.out.println("\n--- Medical Reports ---");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("Patient ID: " + data[0]);
                System.out.println("Diagnosis: " + data[1]);
                System.out.println("Prescription: " + data[2]);
                System.out.println("Date: " + data[3]);
                System.out.println("----------------------");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}