package bt7;

public abstract class Employee implements IEmployee {
    private String name;
    private int paymentPerHour;
    public Employee(String name, int paymentPerHour) {
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    @Override
    public abstract int calculateSalary();

    @Override
    public String getName() {
        return name;
    }
}
