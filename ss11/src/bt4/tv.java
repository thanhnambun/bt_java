package bt4;

public class tv implements Electronic {


    @Override
    public void turnOn() {
        System.out.println("Turning on TV...");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off TV...");
    }
}
