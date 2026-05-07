package FileHandling;
import java.io.*;
import java.util.*;

public class EcommerceApp {

    static final String ORDER_FILE = "orders.txt";
    static final String INVOICE_FILE = "invoices.txt";
    static final String SHIPPING_FILE = "shipping.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== E-COMMERCE SYSTEM ====");
            System.out.println("1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    placeOrder(sc);
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 🔹 Place Order
    public static void placeOrder(Scanner sc) {
        try {
            System.out.print("Enter Order ID: ");
            int orderId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String product = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            double total = qty * price;

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Address: ");
            String address = sc.nextLine();

            // Save Order
            FileWriter orderWriter = new FileWriter(ORDER_FILE, true);
            orderWriter.write(orderId + "," + product + "," + qty + "," + price + "\n");
            orderWriter.close();

            // Save Invoice
            FileWriter invoiceWriter = new FileWriter(INVOICE_FILE, true);
            invoiceWriter.write(orderId + "," + total + "," + new Date() + "\n");
            invoiceWriter.close();

            // Save Shipping
            FileWriter shippingWriter = new FileWriter(SHIPPING_FILE, true);
            shippingWriter.write(orderId + "," + name + "," + address + "\n");
            shippingWriter.close();

            System.out.println("Order placed successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 View Orders
    public static void viewOrders() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ORDER_FILE));
            String line;

            System.out.println("\n--- Order List ---");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("Order ID: " + data[0]);
                System.out.println("Product: " + data[1]);
                System.out.println("Quantity: " + data[2]);
                System.out.println("Price: " + data[3]);
                System.out.println("-------------------");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}