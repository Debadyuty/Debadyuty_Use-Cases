package April_Batch;

public class StudentInfoSystem {
	 public static void main(String[] args) {
	        
	        String name = "Alice";       
	        int age = 20;                
	        float[] marks = {85.5f, 90.0f, 78.5f}; 
	        char grade = 'A';            
            float sum = 0;
	        for (float mark : marks) {
	            sum += mark;
	        }
	        float averageMarks = sum / marks.length;

	        
	        System.out.println("Student Information ");
	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	        System.out.print("Marks: ");
	        for (float mark : marks) {
	            System.out.print(mark + " ");
	        }
	        System.out.println("\nGrade: " + grade);
	        System.out.println("Average Marks: " + averageMarks);
	    }
	}
