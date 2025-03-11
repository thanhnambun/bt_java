public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double deposit(double amount) {
        if (amount > 0) {
            return this.balance += amount;
        }else{
            return Double.NaN;
        }
    }
    public double withdraw(double amount) {
        if (amount > 0) {
            return this.balance -= amount;
        }else {
            System.out.println("số dư không đủ ");
            return Double.NaN;
        }
    }
    public double transfer(BankAccount recipient, double amount) {
        if (amount > this.balance) {
            System.out.println("số tiền trong tài khoản không đủ ");
            return Double.NaN;
        }else {
            this.balance -= amount;
            return recipient.balance +=amount;
        }
    }
    public void display(){
        System.out.printf("số tài khoản %s , tên khách hàng %s , số dư %d\n",this.accountNumber , this.accountHolder,this.balance,this.balance);
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("12345","Tiên",1000.00);
        b1.display();
        BankAccount b2 = new BankAccount("12665","Nam",1000.00);
        b2.display();
        b1.deposit(200.00);
        b1.display();
        b2.deposit(300.00);
        b2.display();
        b2.withdraw(400.00);
        b2.display();
        b1.transfer(b2,500.00);
        b1.display();
        b2.display();
    }
}
