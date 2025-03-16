package bt6;
public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void sound();
    public abstract void move();

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
