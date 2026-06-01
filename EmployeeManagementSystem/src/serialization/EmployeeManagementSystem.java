package serialization;
import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {

    static final String FILE_NAME = "employees.ser";

    static ArrayList<Employee> empList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load existing data
        loadFromFile();

        while (true) {
            System.out.println("\n==== EMPLOYEE MANAGEMENT SYSTEM ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Save Employees");
            System.out.println("4. Load Employees");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    saveToFile();
                    break;
                case 4:
                    loadFromFile();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 🔹 Add Employee
    public static void addEmployee(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        empList.add(new Employee(id, name, salary));
        System.out.println("Employee added!");
    }

    // 🔹 View Employees
    public static void viewEmployees() {
        if (empList.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        for (Employee e : empList) {
            System.out.println("ID: " + e.id);
            System.out.println("Name: " + e.name);
            System.out.println("Salary: " + e.salary);
            System.out.println("------------------");
        }
    }

    // 🔹 Save to File (Serialization)
    public static void saveToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(empList);

            out.close();
            fileOut.close();

            System.out.println("Employees saved successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 Load from File (Deserialization)
    public static void loadFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE_NAME);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            empList = (ArrayList<Employee>) in.readObject();

            in.close();
            fileIn.close();

            System.out.println("Employees loaded successfully!");

        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }
}