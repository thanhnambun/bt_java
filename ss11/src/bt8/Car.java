package bt8;

public abstract class Car {
    protected int year;
    protected String model;
    protected double price;

    public Car(int year, String model, double price) {
        this.year = year;
        this.model = model;
        this.price = price;
    }

    public abstract void start();

    public abstract void stop();
    public String getInfo() {
        return model + " (Năm SX: " + year + ", Giá: $" + price + ")";
    }
}
