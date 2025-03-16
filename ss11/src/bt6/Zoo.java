package bt6;

public class Zoo {
    private Animal[] animals;

    public Zoo(int size) {
        animals = new Animal[size];
    }

    public void addAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                return;
            }
        }
    }

    public void showAnimals() {
        for (Animal animal : animals) {
            if (animal != null) {
                animal.displayInfo();
                animal.sound();
                animal.move();
            }
        }
    }
}
