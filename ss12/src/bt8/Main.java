package bt8;

public class Main {
    public static void main(String[] args) {
        Product electronicProduct = new Electronics("Laptop", 1500);
        Product clothingProduct = new Clothing("T-Shirt", 50);
        Product foodProduct = new Food("Apple", 2);

        System.out.println(electronicProduct.name);
        System.out.println(electronicProduct.price);
        System.out.println("giá mặc định: " + electronicProduct.getFinalPrice());
        System.out.println("giá khi mua nhiều sản phẩm: " + electronicProduct.getFinalPrice(150));
        System.out.println("-----------------------------");

        System.out.println(clothingProduct.name);
        System.out.println(clothingProduct.price);
        System.out.println("giá mặc định: " + clothingProduct.getFinalPrice());
        System.out.println("giá khi mua nhiều sản phẩm: " + clothingProduct.getFinalPrice(80));
        System.out.println("-----------------------------");

        System.out.println(foodProduct.name);
        System.out.println(foodProduct.price);
        System.out.println("giá mặc định : " + foodProduct.getFinalPrice());
        System.out.println("giá khi mua nhiều sản ohaafm: " + foodProduct.getFinalPrice(200));
        System.out.println("-----------------------------");
    }
}

