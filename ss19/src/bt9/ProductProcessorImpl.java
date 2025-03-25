package bt9;

import java.util.ArrayList;
import java.util.List;

public class ProductProcessorImpl implements ProductProcessor {
    @Override
    public int calculateTotalValue(List<Product> products) {
        int sum=0;
        for (Product product : products) {
            sum+=product.getPrice();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("xoài",500));
        products.add(new Product("cam",500));
        products.add(new Product("quts",500));
        products.add(new Product("chuối",500));
        products.add(new Product("khoai",500));
        ProductProcessorImpl productProcessorImpl = new ProductProcessorImpl();
        if (!productProcessorImpl.hasExpensiveProduct(products)) {
            System.out.println("không có sản phẩm nào lớn hơn 100");
        }
        System.out.println(productProcessorImpl.calculateTotalValue(products));
        ProductProcessor.printList(products);
    }
}
