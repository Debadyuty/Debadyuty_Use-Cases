package April_Day5;

public class BankAccount {
	// final keyword ensures immutability after initialization
    private final String accountNumber;
    private double balance;

    // Constructor initializes account number once
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;  // can only be set here
        this.balance = initialBalance;
    }

    // Getter for account number (read-only)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". Current balance: " + balance);
        } else {
            System.out.println("Deposit must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Current balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal.");
        }
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}

public class BankingApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC12345", 1000);

        System.out.println("Account Number: " + account.getAccountNumber());
        account.deposit(500);
        account.withdraw(200);

       
    }
}



