package bt7;

public class PartTimeEmployee extends Employee {
    private int workingHours;
    public PartTimeEmployee(String name, int paymentPerHour) {
        super(name, paymentPerHour);
    }

    @Override
    public int calculateSalary() {
        return workingHours * getPaymentPerHour();
    }

}
