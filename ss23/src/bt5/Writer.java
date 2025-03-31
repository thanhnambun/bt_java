package bt5;

public class Writer extends Thread {
    private SharedData sharedData;

    public Writer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        String[] messages = {
                "Xin chào!",
                "Bạn khỏe không?",
                "Hôm nay thế nào?",
                "Hẹn gặp lại!"
        };
        for (String msg : messages) {
            sharedData.writeMessage(msg);
            try {
                Thread.sleep(1000); // Giả lập độ trễ khi gửi tin
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
