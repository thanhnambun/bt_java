public class Bt2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Bt2 numberPrinter = new Bt2();
        Thread thread = new Thread(numberPrinter);
        thread.start();
    }
}
