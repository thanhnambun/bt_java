package bt7;

public class Car extends Vehicle {
    @Override
    public String move() {
        return "Di chuyển nhanh";
    }

    @Override
    public String sound() {
        return "Vroom";
    }
}

