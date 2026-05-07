package April_Day3;

public class PatientRecord {
	 
    private String name;
    private int age;
    private String patientId;
    private String diagnosis;

    
    public Patient(String name, int age, String patientId, String diagnosis) {
        this.name = name;
        this.age = age;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
    }

    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPatientId() {
        return patientId;
    }

    
    public String getDiagnosis(boolean isDoctor) {
        if (isDoctor) {
            return diagnosis;
        } else {
            return "Access Denied: Confidential Information";
        }
    }

    
    public void updateDiagnosis(String newDiagnosis, boolean isDoctor) {
        if (isDoctor) {
            this.diagnosis = newDiagnosis;
            System.out.println("Diagnosis updated successfully.");
        } else {
            System.out.println("Access Denied: Only doctors can update diagnosis.");
        }
    }
}

public class PatientRecordSystem {
    public static void main(String[] args) {
        
        Patient p1 = new Patient("Debadyuty", 25, "P1001", "Flu");

        
        System.out.println("Patient Name: " + p1.getName());
        System.out.println("Patient Age: " + p1.getAge());
        System.out.println("Patient ID: " + p1.getPatientId());

        
        System.out.println("Diagnosis (non-doctor): " + p1.getDiagnosis(false));

        
        System.out.println("Diagnosis (doctor): " + p1.getDiagnosis(true));

        
        p1.updateDiagnosis("Recovered", true);
    }
}

}
	
