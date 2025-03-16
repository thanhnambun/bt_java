package bt10;

public class DebitCard extends PaymentMethod {
    public DebitCard(double amount) {
        super(amount);
    }
    @Override
    public double calculateFee() {
        return amount * 0.01;
    }
    @Override
    public double processPayment() {
        double fee = calculateFee();
        double totalAmount = amount + fee;
        System.out.println("DebitCard Payment Processed. Total Amount: " + totalAmount);
        return totalAmount;
    }
    @Override
    public String processPayment(double amount, String currency) {
        double totalAmount = processPayment();
        return totalAmount + " " + currency;
    }
}
