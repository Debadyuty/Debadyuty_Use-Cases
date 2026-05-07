package April_Day5;

class Payment {
    // final method ensures secure logic cannot be overridden
    public final void processPayment(double amount) {
        if (amount > 0) {
            System.out.println("Processing secure payment of: $" + amount);
            // secure logic (e.g., encryption, validation, transaction logging)
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    // Non-final method (can be overridden)
    public void paymentDetails() {
        System.out.println("Generic payment details.");
    }
}

// Subclass
class CreditCardPayment extends Payment {
    
    @Override
    public void paymentDetails() {
        System.out.println("Payment via Credit Card.");
    }
}

// Main class with entry point
public class PaymentSystemDemo {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment();
        payment.processPayment(500);   // Calls secure final method
        payment.paymentDetails();      // Calls overridden method
    }
}
