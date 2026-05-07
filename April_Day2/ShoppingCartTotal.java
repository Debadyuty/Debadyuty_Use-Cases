package April_Day2;
import java.util.Scanner;

public class ShoppingCartTotal {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        double total = 0;
	        double price;

	        System.out.println("Enter item prices (0 to finish):");

	        while (true) {
	            price = sc.nextDouble();
	            if (price == 0) {
	                break;
	            }
	            total += price;
	        }

	        System.out.println("Total amount: ₹" + total);

	        sc.close();
	    }
	}

}
