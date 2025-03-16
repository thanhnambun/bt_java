package bt9;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
    public abstract void displayBalance();
}
