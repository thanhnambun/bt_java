package bt1;
public class demo {
    // Biến private => Không ai truy cập trực tiếp được
    private String name;
    private int age;

    // Hàm setName để gán tên mới (setter)
    public void setName(String name) {
        // Kiểm tra: tên không được rỗng
        if (name == null || name.isEmpty()) {
            System.out.println("Tên không hợp lệ!");
        } else {
            this.name = name;
        }
    }

    // Hàm getName để lấy tên (getter)
    public String getName() {
        return name;
    }

    // Hàm setAge để gán tuổi mới (setter)
    public void setAge(int age) {
        // Kiểm tra tuổi không được âm
        if (age < 0) {
            System.out.println("Tuổi không hợp lệ!");
        } else {
            this.age = age;
        }
    }

    // Hàm getAge để lấy tuổi (getter)
    public int getAge() {
        return age;
    }

    // Hiển thị thông tin người
    public void displayInfo() {
        System.out.println("Tên: " + name + ", Tuổi: " + age);
    }
}
