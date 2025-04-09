import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Bt5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ShopDB";
        String user = "root";
        String password = "265205";

        Connection conn = null;
        PreparedStatement insertOrder = null;
        PreparedStatement insertDetail = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            String sqlOrder = "INSERT INTO Orders (customer_name, order_date) VALUES (?, ?)";
            insertOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            insertOrder.setString(1, "Nguyễn Văn A");
            insertOrder.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            insertOrder.executeUpdate();

            rs = insertOrder.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            String sqlDetail = "INSERT INTO OrderDetails (order_id, product_name, quantity) VALUES (?, ?, ?)";
            insertDetail = conn.prepareStatement(sqlDetail);

            List<String> products = Arrays.asList("Bút bi", "Vở", "Tẩy");
            List<Integer> quantities = Arrays.asList(5, 10, -3);

            for (int i = 0; i < products.size(); i++) {
                insertDetail.setInt(1, orderId);
                insertDetail.setString(2, products.get(i));
                insertDetail.setInt(3, quantities.get(i));
                insertDetail.executeUpdate();
            }

            conn.commit();
            System.out.println("Giao dịch thành công!");

        } catch (SQLException e) {
            System.err.println("Giao dịch thất bại. Rollback...");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (insertDetail != null) insertDetail.close();
            } catch (SQLException e) {
            }
            try {
                if (insertOrder != null) insertOrder.close();
            } catch (SQLException e) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
