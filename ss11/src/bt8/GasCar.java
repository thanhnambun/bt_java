package bt8;

public class GasCar extends Car implements Refuelable {
    public GasCar(int year, String model, double price) {
        super(year, model, price);
    }

    @Override
    public void start() {
        super.getInfo();
        System.out.println("  đã khởi động với tiếng động cơ");
    }

    @Override
    public void stop() {
        super.getInfo();
        System.out.println(" đã dừng và động cơ tắt");
    }
    @Override
    public void refuel() {
        super.getInfo();
        System.out.println(" đang được đổ xăng...");
    }
}
