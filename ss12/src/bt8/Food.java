package bt8;

public class Food extends Product {
    public Food(String name, double price) {
        super(name, price);
    }
    @Override
    public double getDiscount() {
        return 5;
    }
}
