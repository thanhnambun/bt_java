package bt5;

public class Bt5 {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Writer writer = new Writer(sharedData);
        Reader reader = new Reader(sharedData);

        writer.start();
        reader.start();
    }
}
