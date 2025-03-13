package bt7;

import java.util.Scanner;

public class testStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GraduateStudent[]  gs = new GraduateStudent[100];
        System.out.println("nhập số lượng sinh viên ");
        int count =0;
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            gs[i] = new GraduateStudent();
            System.out.println("vui lòng nhập tên sinh viên ");
            gs[i].setName(sc.nextLine());
            System.out.println("vui lòng nhập mã sinh viên");
            gs[i].setId(sc.nextLine());
            System.out.println("vui lòng nhập gpa");
            gs[i].setGpa(sc.nextDouble());
            System.out.println("vui lòng nhập đ tài nghiên ứu ");
            gs[i].setResearchTopic(sc.nextLine());
            System.out.println("vui lòng nhập giaos viên hướng dẫn");
            gs[i].setSupervisorName(sc.nextLine());
            count ++;
        }
        for(int i=0;i<count;i++){
            gs[i].getDetails();
        }
    }
}
