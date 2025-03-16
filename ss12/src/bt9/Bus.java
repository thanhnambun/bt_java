package bt9;

public class Bus extends Vehicle {
    private int seats;

    public Bus(String name, int seats) {
        super(name);
        this.seats = seats;
    }

    @Override
    public void move() {
        System.out.println(name + " đi trên mặt đát.");
    }

    @Override
    public void sound() {
        System.out.println(name + "Honk.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Seats: " + seats);
    }
}
