package April_Batch;

public class EmployeeSalaryCalculator {
	 public static void main(String[] args) {
	        
	        double basicSalary = 50000;   
	        double bonus = 10000;         
	        double tax = 8000;            

	       
	        double netSalary = basicSalary + bonus - tax;

	        
	        System.out.println("Employee Salary Calculator ");
	        System.out.println("Basic Salary: " + basicSalary);
	        System.out.println("Bonus: " + bonus);
	        System.out.println("Tax Deduction: " + tax);
	        System.out.println("Net Salary: " + netSalary);
	    }
	}