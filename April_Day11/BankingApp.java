package April_Day11;
import java.io.*;
import java.util.*;

public class BankingApp {

    static final String ACCOUNT_FILE = "accounts.txt";
    static final String TRANSACTION_FILE = "transactions.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== BANKING SYSTEM ====");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount(sc);
                    break;
                case 2:
                    viewAccounts();
                    break;
                case 3:
                    deposit(sc);
                    break;
                case 4:
                    withdraw(sc);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 🔹 Create Account
    public static void createAccount(Scanner sc) {
        try {
            FileWriter writer = new FileWriter(ACCOUNT_FILE, true);

            System.out.print("Enter Account No: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            writer.write(accNo + "," + name + "," + balance + "\n");
            writer.close();

            System.out.println("Account created successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 View Accounts
    public static void viewAccounts() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_FILE));
            String line;

            System.out.println("\n--- Account List ---");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("Acc No: " + data[0]);
                System.out.println("Name: " + data[1]);
                System.out.println("Balance: " + data[2]);
                System.out.println("-------------------");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 Deposit
    public static void deposit(Scanner sc) {
        updateBalance(sc, "Deposit");
    }

    // 🔹 Withdraw
    public static void withdraw(Scanner sc) {
        updateBalance(sc, "Withdraw");
    }

    // 🔹 Update Balance
    public static void updateBalance(Scanner sc, String type) {

        try {
            System.out.print("Enter Account No: ");
            int accNo = sc.nextInt();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            File inputFile = new File(ACCOUNT_FILE);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(tempFile);

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                int fileAccNo = Integer.parseInt(data[0]);
                double balance = Double.parseDouble(data[2]);

                if (fileAccNo == accNo) {
                    found = true;

                    if (type.equals("Deposit")) {
                        balance += amount;
                    } else if (type.equals("Withdraw")) {
                        if (balance >= amount) {
                            balance -= amount;
                        } else {
                            System.out.println("Insufficient balance!");
                        }
                    }

                    writer.write(fileAccNo + "," + data[1] + "," + balance + "\n");

                    // Save transaction
                    saveTransaction(accNo, type, amount);

                } else {
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.close();

            // Replace original file
            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (found) {
                System.out.println(type + " successful!");
            } else {
                System.out.println("Account not found!");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 Save Transaction
    public static void saveTransaction(int accNo, String type, double amount) {
        try {
            FileWriter writer = new FileWriter(TRANSACTION_FILE, true);
            writer.write(accNo + "," + type + "," + amount + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Transaction error: " + e.getMessage());
        }
    }
}