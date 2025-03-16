package bt3;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota Camry", 180);

        Bike myBike = new Bike("Yamaha Exciter", 120);

        System.out.println("Thông tin xe hơi:");
        myCar.start();
        myCar.displayInfo();

        System.out.println("Thông tin xe máy:");
        myBike.start();
        myBike.displayInfo();
    }
}

