package April_Batch;

public class SimpleInterest {
	public static void main(String[] args) {
       
        double principal = 10000;   
        float rate = 5.5f;          
        int time = 3;               
        
        double simpleInterest = (principal * rate * time) / 100;

        
        System.out.println("Simple Interest Calculator");
        System.out.println("Principal: " + principal);
        System.out.println("Rate of Interest: " + rate + "%");
        System.out.println("Time (years): " + time);
        System.out.println("Simple Interest: " + simpleInterest);
	}
}
