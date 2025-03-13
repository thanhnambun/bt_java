package bt1;

public class bt1 {
/*
1. Tính đóng gói là gì?
Đóng gói (Encapsulation) là cách đưa dữ liệu (biến) và các hành động lên dữ liệu đó (phương thức) vào trong một cái hộp (lớp).
Bên ngoài không nhìn thấy trực tiếp dữ liệu bên trong. Nếu muốn xem hay thay đổi, thì phải xin phép (thông qua phương thức getter và setter).
Ví dụ dễ hiểu:
Giống như bạn có một cái tủ khóa, muốn lấy hoặc bỏ đồ vào thì phải dùng chìa khóa (phương thức).

2. Tại sao đóng gói quan trọng?
Giúp bảo vệ dữ liệu: Không ai bên ngoài được sửa lung tung dữ liệu của bạn.
Kiểm soát dữ liệu: Nếu muốn sửa, phải kiểm tra có hợp lệ không.
Làm cho chương trình dễ bảo trì và an toàn hơn.
3. Cách dùng đóng gói trong Java
Bước 1: Để các biến (dữ liệu) là private → không ai chạm vào được.
Bước 2: Tạo getter để lấy giá trị, setter để đổi giá trị (có thể kiểm tra nếu cần).
6. Lợi ích khi dùng đóng gói (Encapsulation):
Bảo vệ dữ liệu: Không ai sửa bậy!
Kiểm soát ai được sửa và sửa thế nào (qua setter).
Dễ sửa mã (code): Nếu muốn thay đổi cách lưu trữ bên trong, chỉ cần sửa trong lớp đó, bên ngoài không ảnh hưởng.
Giúp chương trình chặt chẽ, rõ ràng, dễ hiểu và an toàn hơn.
*/
public static void main(String[] args) {
    demo p = new demo();

    p.setName("Nam");
    p.setAge(25);

    p.displayInfo();


    p.setAge(-5);
}
}
