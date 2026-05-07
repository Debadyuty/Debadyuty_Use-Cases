package April_Day10;
import java.util.*;

//Patient Class
class Patient {
 private String id;
 private String name;
 private int age;
 private String disease;

 public Patient(String id, String name, int age, String disease) {
     this.id = id;
     this.name = name;
     this.age = age;
     this.disease = disease;
 }

 public String getId() {
     return id;
 }

 public void updateDetails(String name, int age, String disease) {
     this.name = name;
     this.age = age;
     this.disease = disease;
 }

 public String toString() {
     return "ID: " + id + ", Name: " + name +
            ", Age: " + age + ", Disease: " + disease;
 }
}


//Hospital System using HashMap
class HospitalSystem {
 private HashMap<String, Patient> patients = new HashMap<>();

 // Add Patient
 public void addPatient(Patient p) {
     if (patients.containsKey(p.getId())) {
         System.out.println("Patient already exists!");
     } else {
         patients.put(p.getId(), p);
         System.out.println("Patient added.");
     }
 }

 // Update Patient
 public void updatePatient(String id, String name, int age, String disease) {
     if (patients.containsKey(id)) {
         patients.get(id).updateDetails(name, age, disease);
         System.out.println("Patient updated.");
     } else {
         System.out.println("Patient not found.");
     }
 }

 // Retrieve Patient
 public void getPatient(String id) {
     Patient p = patients.get(id);
     if (p != null) {
         System.out.println(p);
     } else {
         System.out.println("Patient not found.");
     }
 }

 // Remove Patient
 public void removePatient(String id) {
     if (patients.remove(id) != null) {
         System.out.println("Patient removed.");
     } else {
         System.out.println("Patient not found.");
     }
 }

 // List All Patients
 public void listPatients() {
     if (patients.isEmpty()) {
         System.out.println("No patients available.");
         return;
     }
     for (Patient p : patients.values()) {
         System.out.println(p);
     }
 }

 // Check Existence
 public void exists(String id) {
     if (patients.containsKey(id)) {
         System.out.println("Patient exists.");
     } else {
         System.out.println("Patient does not exist.");
     }
 }

 // Count Patients
 public void countPatients() {
     System.out.println("Total Patients: " + patients.size());
 }

 // Clear System
 public void clearAll() {
     patients.clear();
     System.out.println("All records cleared.");
 }
}


//Main Class (Run this in Eclipse)
public class HospitalApp {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     HospitalSystem system = new HospitalSystem();

     int choice;

     do {
         System.out.println("\n===== Hospital Menu =====");
         System.out.println("1. Add Patient");
         System.out.println("2. Update Patient");
         System.out.println("3. Get Patient");
         System.out.println("4. Remove Patient");
         System.out.println("5. List All Patients");
         System.out.println("6. Check Patient Exists");
         System.out.println("7. Count Patients");
         System.out.println("8. Clear All Records");
         System.out.println("9. Exit");
         System.out.print("Enter choice: ");

         choice = sc.nextInt();
         sc.nextLine(); // consume newline

         switch (choice) {
             case 1:
                 System.out.print("Enter ID: ");
                 String id = sc.nextLine();
System.out.print("Enter Name: ");
                 String name = sc.nextLine();
                 System.out.print("Enter Age: ");
                 int age = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Enter Disease: ");
                 String disease = sc.nextLine();

                 system.addPatient(new Patient(id, name, age, disease));
                 break;

             case 2:
                 System.out.print("Enter ID: ");
                 id = sc.nextLine();
                 System.out.print("Enter New Name: ");
                 name = sc.nextLine();
                 System.out.print("Enter New Age: ");
                 age = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Enter New Disease: ");
                 disease = sc.nextLine();

                 system.updatePatient(id, name, age, disease);
                 break;

             case 3:
                 System.out.print("Enter ID: ");
                 id = sc.nextLine();
                 system.getPatient(id);
                 break;

             case 4:
                 System.out.print("Enter ID: ");
                 id = sc.nextLine();
                 system.removePatient(id);
                 break;

             case 5:
                 system.listPatients();
                 break;

             case 6:
                 System.out.print("Enter ID: ");
                 id = sc.nextLine();
                 system.exists(id);
                 break;

             case 7:
                 system.countPatients();
                 break;

             case 8:
                 system.clearAll();
                 break;

             case 9:
                 System.out.println("Exiting...");
                 break;

             default:
                 System.out.println("Invalid choice!");
         }

     } while (choice != 9);

     sc.close();
 }
}
