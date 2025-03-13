import java.time.Year;

public class Car {
    private String make;
    private String model;
    private int year;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year <Year.now().getValue()) {
            this.year = year;
        }else {
            System.out.println("năm sản xuất không được lớn hơn năm hiện tại");
        }
    }

    public Car(){

    }

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public static void main(String[] args) {
        Car car = new Car("honda","Civic",2020);
        int newYear = 20230;
        car.setYear(newYear);
        System.out.println(car.getYear());
    }
}
