package April_Day11;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SerializeDemo {
	 public static void main(String[] args) {

	        Student s1 = new Student(101, "Rahul");

	        try {
	            FileOutputStream fileOut = new FileOutputStream("student.ser");
	            ObjectOutputStream out = new ObjectOutputStream(fileOut);

	            out.writeObject(s1);

	            out.close();
	            fileOut.close();

	            System.out.println("Object serialized successfully!");

	        } catch (IOException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}


