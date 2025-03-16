package bt9;
public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();

        SavingAccount savingAcc = new SavingAccount("SA123", 1000);
        CheckingAccount checkingAcc = new CheckingAccount("CA456", 500);

        myBank.addBankAccount(savingAcc);
        myBank.addBankAccount(checkingAcc);

        savingAcc.deposit(500);
        savingAcc.withdraw(2000);
        savingAcc.withdraw(800);

        checkingAcc.withdraw(700);
        checkingAcc.deposit(300);

        myBank.displayBalances();
    }
}
