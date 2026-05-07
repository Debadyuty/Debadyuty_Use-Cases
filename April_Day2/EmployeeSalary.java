package April_Day2;

public class EmployeeSalary {
	 public static void main(String[] args) {
	        int salaries = 20000;

	        for (int i = 0; i<=50000; i=i+5000) {
	            salaries=salaries+ ( salaries * 0.10);
	            System.out.println("Updated Salary: " + salaries[i]);
	        }
	    }
	}


