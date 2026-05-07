package April_Day2;
import java.util.Scanner;

public class EvenNumberGenerator {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Even numbers between 1 and " + n + ":");
        for (int i = 2; i <= n; i =i+ 2) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}

}
