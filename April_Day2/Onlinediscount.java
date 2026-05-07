package April_Day2;
import java.util.Scanner;

public class Onlinediscount {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter purchase ammount:");
		double amount=sc.nextDouble();
		double discount=0;
		
		if(amount >=5000) {
			discount=0.20;
		} else if(amount >=2000) {
			discount=0.10;
	    } else if(amount >=1000) {
			discount=0.05;
	    } else {
	    	discount=0;
	    }
		double finalAmount=amount-(amount*discount);
		System.out.println("Final Amount:" +finalAmount);
	}
}

