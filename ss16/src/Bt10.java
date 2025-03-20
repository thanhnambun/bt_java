import java.util.ArrayList;

public class Bt10 {
    private int id;
    private String name;
    private double gpa;
    public Bt10(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", GPA: " + gpa);
    }

    public static void main(String[] args) {
        ArrayList<Bt10> stdList = new ArrayList<Bt10>();
        stdList.add(new Bt10(1, "Nam", 9.1));
        stdList.add(new Bt10(2, "Minh", 5.1));
        stdList.add(new Bt10(3, "Hoa", 3.1));
        stdList.add(new Bt10(4, "Quin", 9.1));
        stdList.add(new Bt10(5, "Chíp", 10));
        for (Bt10 s : stdList) {
            s.display();
        }

        for (int i =0; i < stdList.size(); i++) {
            if(stdList.get(i).gpa >=8.5){
                System.out.println(stdList.get(i).name +" xuất sắc");
            } else if (stdList.get(i).gpa >=7) {
                System.out.println(stdList.get(i).name +" giỏi");
                
            } else if (stdList.get(i).gpa >=5.5) {
                System.out.println(stdList.get(i).name +" khá");
            }else {
                System.out.println(stdList.get(i).name +" trung bình");
            }
        }
    }
}
