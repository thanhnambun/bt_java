package bt10;

import java.util.*;

public class ShoppingCart {
    private Map<String, CartItem> cartItems;

    public ShoppingCart() {
        cartItems = new HashMap<>();
    }

    public void addToCart(Product product, int quantity) {
        if(quantity < 0){
            System.out.println("số lượng phỉa lớn hơn 0");
        }else {
            if(cartItems.containsKey(product.getId())){
                cartItems.get(product.getId()).setQuantity(quantity+cartItems.get(product.getId()).getQuantity());
            }else{
                cartItems.put(product.getId(),new CartItem(product,quantity));
            }
        }
    }

    public void removeFromCart(String productId) {
        if (cartItems.remove(productId) == null) {
            System.out.println("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
        } else {
            System.out.println("Đã xóa sản phẩm khỏi giỏ hàng.");
        }
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng trống.");
            return;
        }
        System.out.println("Danh sách sản phẩm trong giỏ hàng:");
        for (CartItem c : cartItems.values()) {
            System.out.println(c.getProduct().getName() + " - Số lượng: " + c.getQuantity());
        }
    }

    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng trống. Không thể thanh toán.");
            return;
        }
        double total = cartItems.values().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        System.out.println("Tổng tiền cần thanh toán: " + total + " VND");
        cartItems.clear();
        System.out.println("Thanh toán thành công. Giỏ hàng đã được làm trống.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        List<Product> availableProducts = Arrays.asList(
                new Product("P01", "Laptop", 15000000.00),
                new Product("P02", "Điện thoại", 8000000.00),
                new Product("P03", "Tai nghe", 500000.00)
        );

        while (true) {
            System.out.println("\nChọn một chức năng:");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("6. Thoát");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Danh sách sản phẩm có sẵn:");
                    availableProducts.forEach(p ->
                            System.out.println(p.getId() + " - " + p.getName() + " - " + p.getPrice() + " VND"));
                    break;
                case 2:
                    System.out.print("Nhập mã sản phẩm: ");
                    String productId = scanner.nextLine();
                    Product selectedProduct = availableProducts.stream()
                            .filter(p -> p.getId().equals(productId))
                            .findFirst()
                            .orElse(null);
                    if (selectedProduct == null) {
                        System.out.println("Lỗi: Mã sản phẩm không hợp lệ!");
                        break;
                    }
                    System.out.print("Nhập số lượng: ");
                    try {
                        int quantity = Integer.parseInt(scanner.nextLine());
                        cart.addToCart(selectedProduct, quantity);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Số lượng không hợp lệ!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    cart.removeFromCart(scanner.nextLine());
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    cart.checkout();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
