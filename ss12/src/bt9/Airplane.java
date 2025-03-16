package bt9;

public class Airplane extends Vehicle {
    private int altitude;

    public Airplane(String name, int altitude) {
        super(name);
        this.altitude = altitude;
    }

    @Override
    public void move() {
        System.out.println(name + " bay " + altitude + " m.");
    }

    @Override
    public void sound() {
        System.out.println(name + " Whoosh.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Altitude: " + altitude + " m");
    }
}

