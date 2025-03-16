package bt8;

public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getDiscount() {
         return 0.0;
    }
    public double getFinalPrice(){
        return price- (getDiscount()*price)/100;
    }

    public double getDiscount(int quantity){
        if(quantity >100){
            return 5;
        }else {
            return 0;
        }
    }

    public double getFinalPrice(int quantity){
        return price- (getDiscount(quantity)*price)/100;
    }

}
