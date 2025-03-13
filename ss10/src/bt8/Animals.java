package bt8;

public class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animals() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display(){
        System.out.println("tên động vật là " + this.name);
        System.out.println("tuổi động vật là  " + this.age);
    }

    public void makeSound(){
        System.out.println("Some generic sound");
    }
}
