package bt7;

public class Bike extends Vehicle {
    @Override
    public String move() {
        return "Di chuyển chậm";
    }

    @Override
    public String sound() {
        return "Ring Ring";
    }
}

