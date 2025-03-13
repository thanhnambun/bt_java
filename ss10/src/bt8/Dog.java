package bt8;

public class Dog extends Animals {
    private String breed;

    public Dog() {}

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }

    @Override
    public void display(){
        super.display();
        System.out.println("giống chó :" + this.breed);
    }

}
