public class bt6 {

    public static void main(String[] args) {


        String textToAppend = " World";

        long startTimeString = System.currentTimeMillis();

        String str = "Hello";
        for (int i = 0; i < 1000000; i++) {
            str = str + textToAppend;
        }

        long endTimeString = System.currentTimeMillis();
        System.out.println("Thời gian thực thi với String: " + (endTimeString - startTimeString) + " ms");


        long startTimeBuilder = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < 1000000; i++) {
            sb.append(textToAppend);
        }

        long endTimeBuilder = System.currentTimeMillis();
        System.out.println("Thời gian thực thi với StringBuilder: " + (endTimeBuilder - startTimeBuilder) + " ms");

        long startTimeBuffer = System.currentTimeMillis();

        StringBuffer sBuffer = new StringBuffer("Hello");
        for (int i = 0; i < 1000000; i++) {
            sBuffer.append(textToAppend);
        }

        long endTimeBuffer = System.currentTimeMillis();
        System.out.println("Thời gian thực thi với StringBuffer: " + (endTimeBuffer - startTimeBuffer) + " ms");
    }
}
