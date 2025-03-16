package bt6;

public class Employee {
    protected String name;
    protected int age;
    protected double basicSalary;
     public Employee(String name, int age, double basicSalary) {
         this.name = name;
         this.age = age;
         this.basicSalary = basicSalary;
     }

     public double calculateSalary(){
         return this.basicSalary;
     }

     public void showInfo(){
         System.out.println("Name: " + name);
         System.out.println("Age: " + age);
         System.out.println("Basic Salary: " + basicSalary);
     }

}
