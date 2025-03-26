import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Bt9 {
    private int id;
    private String name;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;
    public Bt9(){}

    public Bt9(int id, String name, LocalDate createdDate, Optional<LocalDate> deliveryDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.deliveryDate = deliveryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Optional<LocalDate> getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Optional<LocalDate> deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void toDisplayString(){
        String date = deliveryDate.map(LocalDate::toString).orElse("Chưa giao hàng");
        System.out.println("mã đơn" +id+" tên " +name+" ngày đặt hàng " +createdDate + " ngày giao hàng " +date);
    }

    public static void main(String[] args) {
        List<Bt9> orders = List.of(
                new Bt9(1, "Quý", LocalDate.of(2025, 3, 20), Optional.of(LocalDate.of(2025, 3, 21))),
                new Bt9(2, "Lan", LocalDate.of(2025, 3, 21), Optional.empty()),
                new Bt9(3, "Minh", LocalDate.of(2025, 3, 22), Optional.of(LocalDate.of(2025, 3, 23))),
                new Bt9(4, "Huyền", LocalDate.of(2025, 3, 23), Optional.empty()),
                new Bt9(5, "Việt", LocalDate.of(2025, 3, 23), Optional.of(LocalDate.of(2025, 3, 30)))
        );
        System.out.println("danh sach don hang da giao");
        orders.stream().filter(x->x.getDeliveryDate().isPresent()).forEach(Bt9::toDisplayString);

        System.out.println("danh sách chưa giao");
        orders.stream().filter(x->x.getDeliveryDate().isEmpty()).forEach(Bt9::toDisplayString);
        System.out.println("== Số đơn hàng đã giao từ ngày 2025-03-17 đến 2025-03-23 ==");
         long som=   orders.stream()
                .filter(order -> order.getDeliveryDate().isPresent()
                        && order.getDeliveryDate().get().isAfter(LocalDate.of(2025, 3, 17))
                        && order.getDeliveryDate().get().isBefore(LocalDate.of(2025, 3, 23)))
                .count();
        System.out.println(som);
    }
}
