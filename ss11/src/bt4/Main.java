package bt4;

public class Main {
    public static void main(String[] args) {
        Electronic[] electronics = new Electronic[3];
        electronics[0] = new Radio();
        electronics[1] = new tv();
        electronics[2] = new Radio();
        for (Electronic i : electronics ){
            i.turnOff();
            i.turnOff();
        }
    }
}
