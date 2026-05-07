package April_Day5;

public class SecurityModule {
	 public void encryptData(String data) {
	        System.out.println("Encrypting data: " + data);
	    }

	    public void decryptData(String data) {
	        System.out.println("Decrypting data: " + data);
	    }
	}

	}

	public class Main {
	    public static void main(String[] args) {
	        SecurityModule sm = new SecurityModule();
	        sm.encryptData("Hello");
	        sm.decryptData("World");
	    }
	}



