package April_Day2;

public class ATMSystem {
	public static void main (String[] args) {
	double balance = 5000;
    double withdraw = 2000;

    if (withdraw <= balance) {
        
        System.out.println("Withdrawal Successful");
        
    } else {
        System.out.println("Insufficient Balance");
    }
	}
}


