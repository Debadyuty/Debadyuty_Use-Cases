package April_Day6;
import java.util.Scanner;


class InvalidPinException extends Exception {
 public InvalidPinException(String message) {
     super(message);
 }
}

public class ATMCardExceptionHandling {


 public static void validatePin(int pin) throws InvalidPinException {
     int correctPin = 1234;

     if (pin != correctPin) {
         throw new InvalidPinException("Wrong PIN!");
     }
 }

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     try {
         System.out.println("Card Inserted");
         System.out.print("Enter PIN: ");

         int enteredPin = sc.nextInt();

         
         validatePin(enteredPin);

         
         System.out.println("PIN correct. Access granted.");

     } catch (InvalidPinException e) {
         
         System.out.println("Error: " + e.getMessage());
         System.out.println("Please retry with correct PIN.");

     } catch (Exception e) {
         System.out.println("Invalid input!");
     } finally {
         
         System.out.println("Transaction logged.");
     }

     sc.close();
 }
}


