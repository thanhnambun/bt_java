package bt8;

public class ElectricCar extends Car implements Refuelable {


    public ElectricCar(int year, String model, double price) {
        super(year, model, price);
    }

    @Override
    public void start() {
        super.getInfo();
        System.out.println(" đã khởi động không tiếng ồn");
    }

    @Override
    public void stop() {
        super.getInfo();
        System.out.println(" đã dừng và ngắt kết nối động cơ");
    }
    @Override
    public void refuel() {
        super.getInfo();
        System.out.println(" đang sạc pin");
    }
}
