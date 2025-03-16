package bt7;

public class Bus extends Vehicle {
    @Override
    public String move() {
        return "Di chuyển bình thường";
    }

    @Override
    public String sound() {
        return "Honk Honk";
    }
}

