package April_Day3;

public class BankAccount {
	
    private double balance;

    
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Invalid initial balance. Set to 0.");
        }
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". Current balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Current balance: " + balance);
        }
    }

    
    public double getBalance() {
        return balance;
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        account.deposit(500);
        account.withdraw(200);
        account.withdraw(2000); 
        account.deposit(-50);   

        System.out.println("Final Balance: " + account.getBalance());
    }
}




