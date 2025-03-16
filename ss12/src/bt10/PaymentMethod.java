package bt10;

public abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFee();

    public abstract double processPayment();

    public String processPayment(double amount, String currency) {
        double fee = calculateFee();
        double totalAmount = this.amount + fee;
        return totalAmount + " " + currency;
    }

    public void showInfo() {
        System.out.println("Amount: " + amount);
    }
}
