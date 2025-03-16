package bt8;

public class Garage {
    public class Main {
        public static void main(String[] args) {
            ElectricCar tesla = new ElectricCar(2023,"Tesla Model 3" , 50000);
            GasCar toyota = new GasCar(2022,"Toyota Camry",  35000);

            tesla.start();
            tesla.stop();
            tesla.refuel();

            toyota.start();
            toyota.stop();
            toyota.refuel();
        }
    }

}
