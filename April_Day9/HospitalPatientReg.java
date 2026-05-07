package April_Day9;

import java.util.HashSet;

class HospitalPatientReg {
    public static void main(String[] args) {
        
        HashSet<String> patientIds = new HashSet<>();

        
        registerPatient(patientIds, "P101");
        registerPatient(patientIds, "P102");
        registerPatient(patientIds, "P101"); 
        registerPatient(patientIds, "P103");

        
        System.out.println("\nList of registered patients:");
        for (String id : patientIds) {
            System.out.println(id);
        }
    }

    
    public static void registerPatient(HashSet<String> patientIds, String id) {
        if (patientIds.contains(id)) {
            System.out.println("Patient ID " + id + " is already registered.");
        } else {
            patientIds.add(id);
            System.out.println("Patient ID " + id + " added successfully.");
        }
    }
}
