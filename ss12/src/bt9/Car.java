package bt9;

public class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " di chuyển trên ặt aaast.");
    }

    @Override
    public void sound() {
        System.out.println(name + "Vroom.");
    }
}
