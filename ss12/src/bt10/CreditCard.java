package bt10;

public class CreditCard extends PaymentMethod {
    public CreditCard(double amount) {
        super(amount);
    }
    @Override
    public double calculateFee() {
        return amount * 0.02;
    }
    @Override
    public double processPayment() {
        double fee = calculateFee();
        double totalAmount = amount + fee;
        System.out.println("CreditCard Payment Processed. Total Amount: " + totalAmount);
        return totalAmount;
    }
    @Override
    public String processPayment(double amount, String currency) {
        double totalAmount = processPayment();
        return totalAmount + " " + currency;
    }
}

