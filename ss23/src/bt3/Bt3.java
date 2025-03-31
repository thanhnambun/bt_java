package bt3;

public class Bt3 {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new AlphabetThread(sharedResource, "Thread-1");
        Thread thread2 = new AlphabetThread(sharedResource, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
