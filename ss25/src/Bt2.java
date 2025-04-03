abstract class Animal {
    public abstract void speak();
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Woof! Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Meow! Meow!");
    }
}

class AnimalFactory {
    public static Animal getAnimal(String type) {
        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null;
    }
}

public class Bt2 {
    public static void main(String[] args) {
        Animal animal1 = AnimalFactory.getAnimal("dog");
        if (animal1 != null) {
            animal1.speak();
        }

        Animal animal2 = AnimalFactory.getAnimal("cat");
        if (animal2 != null) {
            animal2.speak();
        }
    }
}
