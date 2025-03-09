public class bt4 {
    public static void main(String[] args) {
        String initialString = "abcdefghij".repeat(100000);

        System.out.println("=== StringBuilder Performance ===");
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder(initialString);

        sb.reverse();
        long endTime = System.nanoTime();
        System.out.println("StringBuilder - Đảo ngược: " + (endTime - startTime) / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        sb.insert(500000, "INSERTED_TEXT");
        endTime = System.nanoTime();
        System.out.println("StringBuilder - Chèn chuỗi: " + (endTime - startTime) / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        sb.delete(400000, 400050);
        endTime = System.nanoTime();
        System.out.println("StringBuilder - Xóa đoạn: " + (endTime - startTime) / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        sb.replace(300000, 300010, "REPLACED");
        endTime = System.nanoTime();
        System.out.println("StringBuilder - Thay thế đoạn: " + (endTime - startTime) / 1_000_000.0 + " ms");

        System.out.println("\n=== StringBuffer Performance ===");
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer(initialString);


        sbf.reverse();
        endTime = System.nanoTime();
        System.out.println("StringBuffer - Đảo ngược: " + (endTime - startTime) / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        sbf.insert(500000, "INSERTED_TEXT");
        endTime = System.nanoTime();
        System.out.println("StringBuffer - Chèn chuỗi: " + (endTime - startTime) / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        sbf.delete(400000, 400050);
        endTime = System.nanoTime();
        System.out.println("StringBuffer - Xóa đoạn: " + (endTime - startTime) / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        sbf.replace(300000, 300010, "REPLACED");
        endTime = System.nanoTime();
        System.out.println("StringBuffer - Thay thế đoạn: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}