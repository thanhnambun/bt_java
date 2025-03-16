package bt9;

public abstract class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public abstract void move();

    public abstract void sound();

    public double move(int time, int speed) {
        double distance = time * speed;
        System.out.println(name + " moved " + distance + " km in " + time + " hours at speed " + speed + " km/h.");
        return distance;
    }

    public void showInfo() {
        System.out.println("Vehicle Name: " + name);
    }
}

