package bt8;

public class Cat extends Animals {
    private String fullColor;

    public Cat(){}

    public Cat(String name, int age, String fullColor) {
        super(name, age);
        this.fullColor = fullColor;
    }

    public String getFullColor() {
        return fullColor;
    }

    public void setFullColor(String fullColor) {
        this.fullColor = fullColor;
    }

    @Override
    public void makeSound(){
        System.out.println("mew mew");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("fullcolor: " + this.fullColor);
    }
}
