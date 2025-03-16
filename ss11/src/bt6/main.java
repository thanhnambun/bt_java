package bt6;

public class main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo(5);

        Animal lion = new Lion("Simba", 5);
        Animal elephant = new Elephant("Dumbo", 10);

        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);

        zoo.showAnimals();
    }
}
