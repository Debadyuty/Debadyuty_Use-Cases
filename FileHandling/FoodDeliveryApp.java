package FileHandling;
import java.io.*;
import java.util.*;

public class FoodDeliveryApp {

    static final String MENU_FILE = "menu.txt";
    static final String ORDER_FILE = "orders.txt";
    static final String DELIVERY_FILE = "delivery.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== FOOD DELIVERY SYSTEM ====");
            System.out.println("1. Add Menu Item");
            System.out.println("2. View Menu");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addMenu(sc);
                    break;
                case 2:
                    viewMenu();
                    break;
                case 3:
                    placeOrder(sc);
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 🔹 Add Menu Item
    public static void addMenu(Scanner sc) {
        try {
            System.out.print("Enter Item ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Item Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            FileWriter writer = new FileWriter(MENU_FILE, true);
            writer.write(id + "," + name + "," + price + "\n");
            writer.close();

            System.out.println("Menu item added!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 View Menu
    public static void viewMenu() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE));
            String line;

            System.out.println("\n--- MENU ---");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("ID: " + data[0]);
                System.out.println("Item: " + data[1]);
                System.out.println("Price: " + data[2]);
                System.out.println("----------------");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 🔹 Place Order
    public static void placeOrder(Scanner sc) {
        try {
            System.out.print("Enter Order ID: ");
            int orderId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Item Name: ");
            String item = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            System.out.print("Enter Price per item: ");
            double price = sc.nextDouble();
            sc.nextLine();

            double total = qty * price;

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Address: ");
            String address = sc.nextLine();

            // Save Order
            FileWriter orderWriter = new FileWriter(ORDER_FILE, true);
            orderWriter.write(orderId + "," + item + "," + qty + "," + total + "\n");
            orderWriter.close();

            // Save Delivery Log
            FileWriter deliveryWriter = new FileWriter(DELIVERY_FILE, true);
            deliveryWriter.write(orderId + "," + name + "," + address + "," + "Pending" + "\n");
            deliveryWriter.close();

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

            System.out.println("\n--- ORDERS ---");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("Order ID: " + data[0]);
                System.out.println("Item: " + data[1]);
                System.out.println("Quantity: " + data[2]);
                System.out.println("Total: " + data[3]);
                System.out.println("----------------");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}