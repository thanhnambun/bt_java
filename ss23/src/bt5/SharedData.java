package bt5;

public class SharedData {
    private String message;
    private boolean hasMessage = false;

    public synchronized void writeMessage(String msg) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = msg;
        hasMessage = true;
        System.out.println("Người gửi: " + msg);
        notify();
    }

    public synchronized void readMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Người nhận: " + message);
        hasMessage = false;
        notify();
    }
}
