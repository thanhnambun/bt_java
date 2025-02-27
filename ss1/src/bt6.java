/*
1. JDK, JRE và JVM – Giải thích chi tiết
Hãy tưởng tượng em muốn chơi một trò chơi điện tử (game). Để làm được điều đó, em cần 3 thứ quan trọng:

Thành phần	So sánh với game	Ý nghĩa trong Java
JVM (Java Virtual Machine)	🕹 Máy chơi game	Chạy chương trình Java. Không có JVM, chương trình Java không thể hoạt động.
JRE (Java Runtime Environment)	📦 Bộ cài game	Chứa JVM + các thư viện cần thiết để chạy ứng dụng Java. Dùng để chạy nhưng không thể lập trình.
JDK (Java Development Kit)	🛠 Bộ làm game	Chứa JRE + Trình biên dịch + Công cụ lập trình. Dùng để viết, biên dịch và chạy chương trình Java.
Mối quan hệ giữa chúng
JDK ⊃ JRE ⊃ JVM
JDK chứa JRE, JRE chứa JVM.
Nếu chỉ muốn chạy ứng dụng Java → Chỉ cần JRE.
Nếu muốn lập trình, biên dịch Java → Phải dùng JDK.
💡 Ví dụ thực tế

Nếu em chỉ muốn chơi game → Chỉ cần tải game về (JRE).
Nếu em muốn tạo game mới → Cần bộ công cụ lập trình (JDK).
2. "Write Once, Run Anywhere" (Viết một lần, chạy mọi nơi) – Ý nghĩa & Cơ chế
"Write Once, Run Anywhere" là gì?
Java có thể chạy trên Windows, macOS, Linux, Android... mà không cần sửa đổi hay biên dịch lại.

Cơ chế hoạt động
Khi em viết chương trình Java, mã nguồn (.java) sẽ được biên dịch thành mã bytecode (.class).
JVM (máy ảo Java) sẽ dịch bytecode này sang ngôn ngữ của từng hệ điều hành.
Vì mọi hệ điều hành đều có JVM riêng, nên Java chạy được ở khắp mọi nơi.
💡 Ví dụ thực tế

Khi em viết game bằng Java, bạn em có thể chơi trên Windows, Mac, Linux mà không cần tạo phiên bản khác.
Nếu em lập trình bằng C++, C#, thì phải biên dịch lại cho từng hệ điều hành khác nhau.
3. Cách cài đặt & chạy chương trình Java đầu tiên bằng IntelliJ IDEA
🔹 Bước 1: Cài đặt JDK & IntelliJ IDEA
Tải và cài đặt JDK từ trang Oracle hoặc OpenJDK.
Tải và cài đặt IntelliJ IDEA từ trang JetBrains.
🔹 Bước 2: Tạo một dự án Java mới
Mở IntelliJ IDEA.
Chọn New Project → Java.
Chọn JDK đã cài đặt → Nhấn Create.
🔹 Bước 3: Viết chương trình Java đầu tiên
Trong thư mục src, nhấp chuột phải → Chọn New → Java Class.
Đặt tên tệp là Main.
Viết đoạn mã sau:
java
Sao chép
Chỉnh sửa
public class Main {
    public static void main(String[] args) {
        System.out.println("Xin chào, Java!");
    }
}
🔹 Bước 4: Chạy chương trình
Nhấn Run (phím tắt: Shift + F10).
Kết quả hiển thị:
nginx
Sao chép
Chỉnh sửa
Xin chào, Java!
💡 Giải thích mã nguồn:

public class Main → Khai báo lớp Main.
public static void main(String[] args) → Phương thức chính để chạy chương trình.
System.out.println("Xin chào, Java!"); → In chuỗi ra màn hình.
4. Các phiên bản Java và sự khác nhau giữa Java SE, Java EE, Java ME
Java có nhiều phiên bản, nhưng phổ biến nhất là Java SE, Java EE, Java ME.

Phiên bản	Dùng để làm gì?	Đối tượng sử dụng
Java SE (Standard Edition)	Phiên bản tiêu chuẩn để lập trình ứng dụng Java thông thường.	Lập trình viên cá nhân, doanh nghiệp nhỏ.
Java EE (Enterprise Edition)	Phiên bản mở rộng của Java SE, dùng để lập trình web, ứng dụng doanh nghiệp.	Công ty phần mềm, hệ thống ngân hàng, thương mại điện tử.
Java ME (Micro Edition)	Phiên bản rút gọn, chạy trên thiết bị di động, IoT, hệ thống nhúng.	Nhà phát triển thiết bị di động, hệ thống IoT.
💡 Ví dụ thực tế

Java SE: Viết ứng dụng quản lý nhân sự, game Java đơn giản.
Java EE: Viết website thương mại điện tử, hệ thống ngân hàng.
Java ME: Viết ứng dụng trên điện thoại Nokia đời cũ, thiết bị IoT.
*/