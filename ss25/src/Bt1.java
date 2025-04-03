class Account {
    private static Account instance;
    private int id;
    private String name;
    private int age;

    private Account() {}

    public static Account getInstance() {
        if (instance == null) {
            instance = new Account();
        }
        return instance;
    }

    public void setAccountInfo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}

public class Bt1 {
    public static void main(String[] args) {
        Account acc1 = Account.getInstance();
        acc1.setAccountInfo(1, "John Doe", 25);
        acc1.displayInfo();

        Account acc2 = Account.getInstance();
        acc2.displayInfo();

        System.out.println(acc1 == acc2);
    }
}
