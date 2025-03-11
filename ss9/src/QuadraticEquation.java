public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant(){
        return Math.pow(this.b,2) - 4*this.c*this.a;
    }
    public void hasRealRoots(){
        if(getDiscriminant()>=0){
            System.out.println("phương trình có nghiệm thực ");
        }
    }
    public double getRoot1(){
        if(getDiscriminant()>=0){
            return (-this.b + Math.sqrt(getDiscriminant())) / (2*this.a) ;
        }else {
            System.out.println("Not a Number");
            return Double.NaN;
        }
    }
    public double getRoot2(){
        if(getDiscriminant()>=0){
            return (-this.b - Math.sqrt(getDiscriminant())) / (2*this.a);
        }else  {
            System.out.println("Not a Number");
            return Double.NaN;
        }
    }
    public void disphay(){
        if(getDiscriminant()>=0){
            System.out.println("nghiệm thư 1  là :" + getRoot1());
            System.out.println("nghiệm thư 2  là :" + getRoot2());
        }else{
            System.out.println("Not a Number");
        }
    }
    public static void main(String[] args) {
        QuadraticEquation q = new QuadraticEquation(1,2,3);
        q.getDiscriminant();
        q.hasRealRoots();
        q.getRoot1();
        q.getRoot2();
        q.disphay();
    }
}
