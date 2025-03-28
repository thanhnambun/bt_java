import entity.Product;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    private static final List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("********** MENU **********");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Lọc sản phẩm theo điều kiện");
            System.out.println("7. Sắp xếp sản phẩm theo giá");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayProducts();
                case 2 -> addProduct(scanner);
                case 3 -> updateProduct(scanner);
                case 4 -> deleteProduct(scanner);
                case 5 -> findProductByName(scanner);
                case 6 -> filterProducts(scanner);
                case 7 -> sortProducts(scanner);
                case 8 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void displayProducts() {
        productList.forEach(System.out::println);
    }

    public static void addProduct(Scanner sc) {
        Product product = new Product();
        product.inputdata(sc);
        productList.add(product);
    }

    public static Optional<Product> findProductById(Optional<Integer> productId) {
        return productList.stream()
                .filter(p -> p.getProductId().isPresent() && productId.isPresent()
                        && p.getProductId().get().equals(productId.get()))
                .findFirst();
    }

    public static void deleteProduct(Scanner sc) {
        System.out.print("Vui lòng nhập ID sản phẩm cần xóa: ");
        Optional<Integer> id = Optional.of(sc.nextInt());

        Optional<Product> productOpt = findProductById(id);

        if (productOpt.isPresent()) {
            productList.remove(productOpt.get());
            System.out.println("Sản phẩm đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID: " + id);
        }
    }


    public static void updateProduct(Scanner sc) {
        System.out.println("vui lòng nhập id");
        Optional<Integer> id = Optional.of(sc.nextInt());
        Optional<Product> productOpt = findProductById(id);
        if (productOpt.isPresent()) {
            System.out.println("Sản phẩm tìm thấy: ");
            productOpt.get().display();

            System.out.println("Chọn thông tin muốn cập nhật:");
            System.out.println("1. Tên sản phẩm");
            System.out.println("2. Giá sản phẩm");
            System.out.println("3. Danh mục sản phẩm");
            System.out.println("4. Thoát");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhập tên sản phẩm mới (30-100 ký tự):");
                    String newName= sc.nextLine();
                    if(newName.length()>30&&newName.length()<100) {
                        boolean check = productList.stream().anyMatch(p -> p.getProductName().equals(Optional.of(newName)));
                        if(check) {
                            productOpt.get().setProductName(Optional.of(newName)) ;
                        }else {
                            System.out.println("tên đã đc sử dụng");
                        }
                    }else {
                        System.out.println("sai yêu cầu");
                    }
                    break;
                case 2:
                    System.out.println("Nhập giá sản phẩm mới (> 0):");
                    float newPrice;
                    do {
                        newPrice = sc.nextFloat();
                        if (newPrice <= 0) {
                            System.out.println("Giá sản phẩm phải lớn hơn 0. Nhập lại:");
                        }
                    } while (newPrice <= 0);
                    productOpt.get().setPrice(newPrice);
                    System.out.println("Giá sản phẩm đã cập nhật!");
                    break;

                case 3:
                    System.out.println("Nhập danh mục sản phẩm mới:");
                    String newCategory = sc.nextLine();
                    productOpt.get().setCategory(newCategory);
                    System.out.println("Danh mục sản phẩm đã cập nhật!");
                    break;

                case 4:
                    System.out.println("Thoát cập nhật.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm có ID: " + id);
        }

    }


    private static void findProductByName(Scanner scanner) {

    }

    public static void filterProducts(Scanner sc) {
        System.out.println("1.Lọc sản phẩm có giá lớn hơn X");
        System.out.println("2.Lọc sản phẩm theo danh mục");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("vui lòng nhập x ");
            float priceCheck = sc.nextFloat();
            productList.stream().filter(p->p.getPrice()==priceCheck).forEach(System.out::println);

        } else if (choice == 2) {
            productList.stream().map(Product ::getCategory).forEach(System.out::println);
        }
    }

    public static void sortProducts(Scanner sc) {
        System.out.println("1 tăng dần");
        System.out.println("2 giảm dần");
        int choice = sc.nextInt();
        if (choice == 1) {
            productList.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(System.out::println);
        } else if (choice == 2) {
            productList.stream()
                    .sorted(Comparator.comparing(Product::getPrice).reversed())
                    .forEach(System.out::println);
        }
    }

}