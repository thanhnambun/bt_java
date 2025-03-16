package bt9;

public class Bike extends Vehicle {

    public Bike(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " đi chậm.");
    }

    @Override
    public void sound() {
        System.out.println(name + "Ring Ring.");
    }
}

