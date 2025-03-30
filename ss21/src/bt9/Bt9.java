package bt9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bt9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("123456", 1000000));
        accounts.add(new BankAccount("654321", 500000));
        accounts.add(new BankAccount("789012", 2000000));
        accounts.get(1).withdraw(sc);
        accounts.get(1).deposit(sc);
        accounts.get(1).Transfer(sc,accounts.get(2));
    }
}
