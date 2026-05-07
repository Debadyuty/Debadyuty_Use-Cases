package April_Day2;

public class FoodMenu {
	public static void main(String[] args) {
        int choice = 2;

        switch (choice) {
            case 1:
                System.out.println("You selected Pizza");
                break;
            case 2:
                System.out.println("You selected Burger");
                break;
            case 3:
                System.out.println("You selected Pasta");
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}



