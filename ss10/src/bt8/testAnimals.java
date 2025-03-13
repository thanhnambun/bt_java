package bt8;

public class testAnimals {
    public static void main(String[] args) {
        Animals[] animals = new Animals[100];
        animals[0] = new Dog("Rex", 3, "Chihuahua");
        animals[1] = new Dog("Buddy", 5, "Labrador");
        animals[2] = new Cat("Kitty", 2, "Trắng");
        animals[3] = new Cat("Mimi", 4, "Đen");
        for (int i = 0; i < 4; i++) {
            animals[i].display();
            animals[i].makeSound();
        }
    }
}
