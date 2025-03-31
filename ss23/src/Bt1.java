public class Bt1 extends Thread {
    public Bt1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread đang chạy: " + getName());
    }
    public static void main(String[] args) {
        Bt1 thread1 = new Bt1("Thread-1");
        Bt1 thread2 = new Bt1("Thread-2");

        thread1.start();
        thread2.start();
    }

}
