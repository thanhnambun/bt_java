package bt3;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound();
        cat.makeSound();

        Animal genericAnimal = new Animal();
        genericAnimal.makeSound();
    }
}
