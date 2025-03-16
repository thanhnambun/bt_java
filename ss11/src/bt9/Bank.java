package bt9;

public class Bank {
    private BankAccount[] bankAccounts;
    private int count;

    public Bank() {
        bankAccounts = new BankAccount[10];
        count = 0;
    }

    public void addBankAccount(BankAccount bankAccount) {
        for (int i = 0; i < bankAccounts.length; i++) {
            if (bankAccounts[i] == null) {
                bankAccounts[i] = bankAccount;
                count++;
                return;
            }
        }
    }

    public void displayBalances() {
        System.out.println("\n--- DANH SÁCH TÀI KHOẢN ---");
        for (int i = 0; i < bankAccounts.length; i++) {
            if (bankAccounts[i] != null) {
                bankAccounts[i].displayBalance();
            }
        }
    }
}
