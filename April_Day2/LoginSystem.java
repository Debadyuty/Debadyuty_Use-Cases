package April_Day2;


public class LoginSystem {
	public static void main(String[] args) {

        String username = "admin";
        String password = "1234";

        switch (username) {
            case "admin":
                if (password.equals("1234")) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Login Failed");
                }
                break;

            case "user":
                if (password.equals("abcd")) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Login Failed");
                }
                break;

            default:
                System.out.println("Login Failed");
        }
    }
}




