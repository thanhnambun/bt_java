package bt9;

import java.util.List;

public interface ProductProcessor {
    int calculateTotalValue(List<Product> products);
    static void printList(List<Product> products){
        products.forEach(System.out::println);
    }
    default boolean hasExpensiveProduct(List<Product> products){
        boolean check = true;
        for(Product product : products){
            if (product.getPrice() >100){
                System.out.println(product);
                check = false;
            }
        }
        return check;
    }
}
