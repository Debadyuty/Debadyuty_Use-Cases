package April_Day2;
import java.util.Scanner;

public class PasswordRetry {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctPassword = "java123";
        int attempts = 0;
        boolean success = false;

        // Using while loop
        while (attempts < 3) {
            System.out.print("Enter password: ");
            String entered = sc.nextLine();

            if (entered.equals(correctPassword)) {
                System.out.println("Access Granted!");
                success = true;
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
                attempts++;
            }
        }

        if (!success) {
            System.out.println("Access Denied! Too many failed attempts.");
        }

        sc.close();
    }
}


