package April_Day4;
import java.util.*;


class Patient {                                                   // Patient Class as Encapsulation
 private int id;
 private String name;
 private int age;
 private String illness;

 public Patient(int id, String name, int age, String illness) {
     this.id = id;
     this.name = name;
     this.age = age;
     this.illness = illness;
 }

 
 public int getId() {                                              // getters
     return id;
 }

 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }

 public String getIllness() {
     return illness;
 }

 
 public void setName(String name) {                                // Setters
     this.name = name;
 }

 public void setAge(int age) {
     this.age = age;
 }

 public void setIllness(String illness) {
     this.illness = illness;
 }
}


interface PatientService {                                          // PatientService as Interface
 void registerPatient(Patient patient);
 void showPatientDetails(int patientId);
}


class PatientServiceImpl implements PatientService {                // Implements Class
 private Map<Integer, Patient> patientMap = new HashMap<>();

 @Override
 public void registerPatient(Patient patient) {
     patientMap.put(patient.getId(), patient);
     System.out.println("Patient registered successfully: " + patient.getName());
 }

 @Override
 public void showPatientDetails(int patientId) {
     Patient patient = patientMap.get(patientId);
     if (patient != null) {
         System.out.println("\nPatient Details:");
         System.out.println("ID: " + patient.getId());
         System.out.println("Name: " + patient.getName());
         System.out.println("Age: " + patient.getAge());
         System.out.println("Illness: " + patient.getIllness());
     } else {
         System.out.println("Patient not found!");
     }
 }
}


abstract class Doctor {                                             // Abstraction Doctor Class
 protected String name;
 protected String specialization;

 public Doctor(String name, String specialization) {
     this.name = name;
     this.specialization = specialization;
 }

 abstract void diagnose(Patient patient);
}


class GeneralPhysician extends Doctor {                             //Inheritance (physician inherits Doc)

 public GeneralPhysician(String name) {
     super(name, "General Physician");
 }

 @Override
 void diagnose(Patient patient) {
     System.out.println("\nDr. " + name + " (General Physician) is diagnosing " + patient.getName());
     System.out.println("Basic diagnosis for illness: " + patient.getIllness());
 }
}


class Cardiologist extends Doctor {                               //Inheritance (Cardiologist inherits Doc)

 public Cardiologist(String name) {
     super(name, "Cardiologist");
 }

 @Override
 void diagnose(Patient patient) {
     System.out.println("\nDr. " + name + " (Cardiologist) is diagnosing " + patient.getName());

     if (patient.getIllness().toLowerCase().contains("heart")) {
         System.out.println("Specialized cardiac diagnosis for: " + patient.getIllness());
     } else {
         System.out.println("Not a heart-related issue. Refer to General Physician.");
     }
 }
}

                                                           
public class healthcaremodule {

 public static void main(String[] args) {                            // main class POE of code

     
     PatientService service = new PatientServiceImpl();

     
     Patient p1 = new Patient(1, "Debadyuty", 24, "Fever");
     Patient p2 = new Patient(2, "Kaustav", 35, "Heart Pain");

     
     service.registerPatient(p1);
     service.registerPatient(p2);

     
     service.showPatientDetails(1);
     service.showPatientDetails(2);

     
     Doctor gp = new GeneralPhysician("Rajiv Ganguly");
     Doctor cardio = new Cardiologist("Alok Maity");

     
     gp.diagnose(p1);
     gp.diagnose(p2);

     cardio.diagnose(p1);
     cardio.diagnose(p2);
 }
}