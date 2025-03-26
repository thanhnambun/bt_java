import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Bt4 {
    private String name;
    private LocalDate birthday;
    public  Bt4(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public int getAge(){
        Period period = Period.between(birthday, LocalDate.now());
        return period.getYears();
    }
    public void printInfo(){
        System.out.println("tên "+this.name + "ngay sinh " +this.birthday+"tuôi" +getAge());
    }

    public static void main(String[] args) {
        List<Bt4> people = List.of(
                new Bt4("Quý", LocalDate.of(2000, 3, 25)),

                new Bt4("Lan", LocalDate.of(1998, 7, 10)),

                new Bt4("Minh", LocalDate.of(2005, 12, 1))

        );
        people.forEach(Bt4::printInfo);
    }
}
