package April_Day7;

//Thread 1 -> Order Processing
class OrderProcessing implements Runnable {
 @Override
 public void run() {
     System.out.println("Order Processing Started...");
     try {
         Thread.sleep(2000);
     } catch (InterruptedException e) {
         System.out.println(e);
     }
     System.out.println("Order Processed Successfully!");
 }
}

//Thread 2 -> Payment Processing
class PaymentProcessing implements Runnable {
 @Override
 public void run() {
     System.out.println("Payment Processing Started...");
     try {
         Thread.sleep(1500);
     } catch (InterruptedException e) {
         System.out.println(e);
     }
     System.out.println("Payment Completed!");
 }
}

//Thread 3 -> Notification
class NotificationService implements Runnable {
 @Override
 public void run() {
     System.out.println("Sending Notification...");
     try {
         Thread.sleep(1000);
     } catch (InterruptedException e) {
         System.out.println(e);
     }
     System.out.println("Notification Sent to User!");
 }
}

//Main Class
public class FoodDeliverySystem {
 public static void main(String[] args) {

     // Creating Runnable objects
     Runnable order = new OrderProcessing();
     Runnable payment = new PaymentProcessing();
     Runnable notification = new NotificationService();

     // Creating Threads
     Thread t1 = new Thread(order);
     Thread t2 = new Thread(payment);
     Thread t3 = new Thread(notification);

     // Starting Threads
     t1.start();
     t2.start();
     t3.start();
 }
}