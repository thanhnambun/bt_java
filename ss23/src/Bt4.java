public class Bt4 extends Thread {
    private String threadName;

    public Bt4(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        if ("Thread 1".equals(threadName)) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + ": " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println(threadName + " bắt đầu");
        }
    }

    public static void main(String[] args) {
        Bt4 thread1 = new Bt4("Thread 1");
        Bt4 thread2 = new Bt4("Thread 2");
        Bt4 thread3 = new Bt4("Thread 3");

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        thread3.start();
    }
}

