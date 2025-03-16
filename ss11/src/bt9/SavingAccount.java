package bt9;

public class SavingAccount extends BankAccount {

    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount < balance) {
            balance -= amount;
        }else {
            System.out.println("số tiền rút vuotj quá số dư hiện tại ");
        }
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
