package bt10;

public class Cash extends PaymentMethod {
    public Cash(double amount) {
        super(amount);
    }
    @Override
    public double calculateFee() {
        return 0.0;
    }
    @Override
    public double processPayment() {
        double fee = calculateFee();
        double totalAmount = amount + fee;
        System.out.println("Cash Payment Processed. Total Amount: " + totalAmount);
        return totalAmount;
    }
    @Override
    public String processPayment(double amount, String currency) {
        double totalAmount = processPayment();
        return totalAmount + " " + currency;
    }
}
