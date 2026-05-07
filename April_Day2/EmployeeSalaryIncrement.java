package April_Day2;
import java.util.Scanner;

public class EmployeeSalaryIncrement {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        double[] salaries = new double[n];

        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            salaries[i] = sc.nextDouble();
        }

        
        for (int i = 0; i < n; i++) {
            salaries[i] = salaries[i] + (salaries[i] * 0.10);
        }

        
        System.out.println("\nUpdated Salaries:");
        for (int i = 0; i < n; i++) {
            System.out.println("Employee " + (i + 1) + ": " + salaries[i]);
        }

        sc.close();
    }
}

