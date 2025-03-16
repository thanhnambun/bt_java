package bt3;
public class Car extends Vehicle {

    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Name: " + name);
        System.out.println("Speed: " + speed + " km/h");
    }
}
