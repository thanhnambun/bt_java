import java.util.Scanner;

public class Student {
    public enum Gender {
        MALE, FEMALE, OTHER;
    }

    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String number;

    public Student() {
    }

    public Student(int id, String name, int age, Gender gender, String address, String number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.number = number;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id của sinh viên: ");
        this.id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên của sinh viên: ");
        this.name = sc.nextLine();
        System.out.println("Nhập tuổi của sinh viên: ");
        this.age = sc.nextInt();
        System.out.println("Chọn giới tính: 1. Nam  2. Nữ  3. Khác");
        int genderChoice = sc.nextInt();
        switch (genderChoice) {
            case 1:
                this.gender = Gender.MALE;
                break;
            case 2:
                this.gender = Gender.FEMALE;
                break;
            default:
                this.gender = Gender.OTHER;
                break;
        }
        sc.nextLine();
        System.out.println("Nhập địa chỉ của sinh viên: ");
        this.address = sc.nextLine();
        System.out.println("Nhập số điện thoại của sinh viên: ");
        this.number = sc.nextLine();
    }

    public void displayData() {
        System.out.println("ID: " + this.id);
        System.out.println("Tên: " + this.name);
        System.out.println("Tuổi: " + this.age);
        System.out.println("Giới tính: " + this.gender);
        System.out.println("Địa chỉ: " + this.address);
        System.out.println("Số điện thoại: " + this.number);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int n = 0;

        System.out.println("Vui lòng nhập số sinh viên cần thêm ban đầu: ");
        int soSinhVienBanDau = sc.nextInt();
        for (int i = 0; i < soSinhVienBanDau; i++) {
            System.out.println("=== Nhập thông tin sinh viên thứ " + (i + 1) + " ===");
            students[n] = new Student();
            students[n].inputData();
            n++;
        }

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Hiển thị danh sách sinh viên ");
            System.out.println("2. Thêm mới sinh viên ");
            System.out.println("3. Sửa thông tin sinh viên ");
            System.out.println("4. Xóa sinh viên ");
            System.out.println("5. Thoát");
            System.out.print("Mời chọn: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=== Danh sách sinh viên ===");
                    if (n == 0) {
                        System.out.println("Chưa có sinh viên nào!");
                    } else {
                        for (int i = 0; i < n; i++) {
                            students[i].displayData();
                        }
                    }
                    break;
                case 2:
                    if (n >= students.length) {
                        System.out.println("Danh sách sinh viên đã đầy!");
                        break;
                    }
                    System.out.println("=== Thêm mới sinh viên ===");
                    students[n] = new Student();
                    students[n].inputData();
                    n++;
                    break;
                case 3:
                    System.out.println("vui lòng nhập id sinh viên cần sửa ");
                    int id = sc.nextInt();
                    boolean check = false;
                    for(int i = 0; i < students.length; i++){
                        if(id == students[i].id){
                            check = true;
                            students[i].id = id;
                            System.out.println("Nhập tên của sinh viên: ");
                            students[i].name = sc.nextLine();
                            System.out.println("Nhập tuổi của sinh viên: ");
                            students[i].age = sc.nextInt();
                            System.out.println("Chọn giới tính: 1. Nam  2. Nữ  3. Khác");
                            int genderChoice = sc.nextInt();
                            switch (genderChoice) {
                                case 1:
                                    students[i].gender = Gender.MALE;
                                    break;
                                case 2:
                                    students[i].gender = Gender.FEMALE;
                                    break;
                                default:
                                    students[i].gender = Gender.OTHER;
                                    break;
                            }
                            sc.nextLine();
                            System.out.println("Nhập địa chỉ của sinh viên: ");
                            students[i].address = sc.nextLine();
                            System.out.println("Nhập số điện thoại của sinh viên: ");
                            students[i].number = sc.nextLine();
                        }
                    }
                    if(check == false){
                        System.out.println("không tìm thấy sinh viên có id " + id);
                    }
                    break;
                case 4:
                    System.out.println("Nhập ID sinh viên cần xóa: ");
                    int idDel = sc.nextInt();
                    sc.nextLine();

                    boolean deleted = false;
                    for (int i = 0; i < n; i++) {
                        if (students[i].id == idDel) {
                            for (int j = i; j < n - 1; j++) {
                                students[j] = students[j + 1];
                            }
                            students[n - 1] = null;
                            n--;
                            deleted = true;
                            System.out.println("Đã xóa sinh viên có ID: " + idDel);
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Không tìm thấy sinh viên có ID: " + idDel);
                    }
                    break;
                case 5:
                    System.out.println("Đã thoát chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (true);
    }
}
