package bt9;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    @Override
    public void deposit(double amount) {
        if (amount >0){
            balance += amount;
        }else {
            System.out.println("số tiên fkhoong hợp lệ ");
        }
    }

    @Override
    public void displayBalance() {
        System.out.println("số tài khoản "+accountNumber+"có soo d"+balance);
    }
}
