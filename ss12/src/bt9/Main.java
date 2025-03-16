package bt9;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota");
        Vehicle bike = new Bike("Honda Bike");
        Vehicle bus = new Bus("City Bus", 50);
        Vehicle airplane = new Airplane("Boeing 747", 10000);

        Vehicle[] vehicles = {car, bike, bus, airplane};
        for (Vehicle v : vehicles) {
            v.showInfo();
            v.move();
            v.sound();
            v.move(2, 60);
            System.out.println();
        }
    }
}

