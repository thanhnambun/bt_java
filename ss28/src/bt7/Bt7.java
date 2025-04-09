package bt7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bt7 {
    public static void main(String[] args) {
        try {
            Connection conn1 = DBUtil.getConnection();
            Connection conn2 = DBUtil.getConnection();
            conn1.setAutoCommit(false);
            conn2.setAutoCommit(false);

            conn1.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

            PreparedStatement stmt2 = conn2.prepareStatement("INSERT INTO orders (customer_name, status) VALUES (?, ?)");
            stmt2.setString(1, "Nam");
            stmt2.setString(2, "Pending");
            stmt2.executeUpdate();

            System.out.println("Kết quả SELECT từ Connection 1:");
            Statement stmt1 = conn1.createStatement();
            ResultSet rs = stmt1.executeQuery("SELECT * FROM orders");
            while (rs.next()) {
                System.out.println(rs.getInt("order_id") + " | " + rs.getString("customer_name") + " | " + rs.getString("status"));
            }

            conn1.rollback();
            conn2.rollback();

            stmt1.close();
            stmt2.close();
            conn1.close();
            conn2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
