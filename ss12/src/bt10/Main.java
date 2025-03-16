package bt10;

public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard(265000);
        PaymentMethod debitCard = new DebitCard(28000);
        PaymentMethod cash = new Cash(10000);

        System.out.println(" thẻ tín dụng ");
        creditCard.showInfo();
        System.out.println("CreditCard Fee: " + creditCard.calculateFee());
        String ccTotalWithCurrency = creditCard.processPayment(creditCard.amount, "USD");
        System.out.println("thẻ tín dụng: " + ccTotalWithCurrency);

        System.out.println("\n thẻ ghi nợ ");
        debitCard.showInfo();
        System.out.println("DebitCard Fee: " + debitCard.calculateFee());
        String dcTotalWithCurrency = debitCard.processPayment(debitCard.amount, "EUR");
        System.out.println("thẻ ghi nợ: " + dcTotalWithCurrency);

        System.out.println("\n tiền mawt ");
        cash.showInfo();
        System.out.println("Cash Fee: " + cash.calculateFee());
        double cashTotal = cash.processPayment();
        String cashTotalWithCurrency = cash.processPayment(cash.amount, "VND");
        System.out.println("tiền mặt: " + cashTotalWithCurrency);
    }
}

