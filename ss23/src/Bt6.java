public class Bt6 extends Thread {
    public Bt6(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Ưu tiên: " + getPriority() + " - Lần lặp: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Bt6 thread1 = new Bt6("Thread 1 (Thấp)", Thread.MIN_PRIORITY);
        Bt6 thread2 = new Bt6("Thread 2 (Trung bình)", Thread.NORM_PRIORITY);
        Bt6 thread3 = new Bt6("Thread 3 (Cao)", Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
