public class bt2 {
    /*
    1. Kế thừa là gì? Nó giúp ích gì trong lập trình hướng đối tượng?
Kế thừa (Inheritance) là một tính năng của lập trình hướng đối tượng, cho phép một lớp con (subclass) kế thừa các thuộc tính (biến) và phương thức (hàm) từ một lớp cha (superclass).

Hiểu đơn giản:

Lớp cha là mẫu thiết kế chung (ví dụ: Animal là một động vật).
Lớp con tái sử dụng những gì lớp cha có và mở rộng thêm (ví dụ: Dog là một con vật, có thêm đặc điểm riêng là sủa "Woof").
Tác dụng:

Tái sử dụng mã nguồn: Không cần viết lại những thuộc tính hay phương thức giống nhau.
Dễ bảo trì, mở rộng hệ thống.
2. Sự khác biệt giữa Kế thừa và Đóng gói (Encapsulation)
Kế thừa (Inheritance)	Đóng gói (Encapsulation)
Là mối quan hệ giữa các lớp (cha - con).	Là che giấu dữ liệu bên trong lớp.
Giúp tái sử dụng và mở rộng lớp cha.	Giúp bảo vệ dữ liệu, chỉ cho phép truy cập qua getter/setter.
Dùng từ khóa extends để kế thừa.	Dùng từ khóa private, public, protected để kiểm soát quyền truy cập.
Tập trung vào chia sẻ và mở rộng hành vi.	Tập trung vào bảo vệ và ẩn thông tin nội bộ.

     */

    public class Animal {
        String name;

        public void eat() {
            System.out.println(name + " đang ăn.");
        }
    }

    public class Dog extends Animal {
        public void bark() {
            System.out.println(name + " sủa: Woof Woof!");
        }
    }

    public class Main {
        public void main(String[] args) {
            Dog dog = new Dog();
            dog.name = "Chó Mực";

            dog.eat();
            dog.bark();
        }
    }

}
