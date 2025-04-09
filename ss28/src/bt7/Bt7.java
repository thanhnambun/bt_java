package bt7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bt7 {
    public static void main(String[] args) {
        try {
            Statement DBUtil;
            Connection conn1 = DBUtil.getConnection(); // đọc
            Connection conn2 = DBUtil.getConnection(); // ghi

            conn1.setAutoCommit(false);
            conn2.setAutoCommit(false);

            // SET ISOLATION LEVEL cho conn1
            conn1.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

            // Connection 2: INSERT nhưng chưa commit
            PreparedStatement stmt2 = conn2.prepareStatement("INSERT INTO orders (customer_name, status) VALUES (?, ?)");
            stmt2.setString(1, "Nam");
            stmt2.setString(2, "Pending");
            stmt2.executeUpdate();

            // Connection 1: SELECT
            System.out.println("Kết quả SELECT từ Connection 1:");
            Statement stmt1 = conn1.createStatement();
            ResultSet rs = stmt1.executeQuery("SELECT * FROM orders");
            while (rs.next()) {
                System.out.println(rs.getInt("order_id") + " | " + rs.getString("customer_name") + " | " + rs.getString("status"));
            }

            // Đừng commit để thấy kết quả chưa xác nhận
            conn1.rollback(); // rollback đọc
            conn2.rollback(); // rollback ghi (dữ liệu chưa commit)

            stmt1.close();
            stmt2.close();
            conn1.close();
            conn2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
