import java.sql.*;

public class Bt2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        String jdbcUrl = "jdbc:mysql://localhost:3306/ss28";
        String username = "root";
        String password = "265205";

        try {
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            conn.setAutoCommit(false);
            System.out.println("Kết nối thành công và đã tắt auto-commit.");

            String insert1 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            stmt1 = conn.prepareStatement(insert1);
            stmt1.setInt(1, 1);
            stmt1.setString(2, "Le Van A");
            stmt1.setString(3, "a@example.com");
            stmt1.executeUpdate();
            System.out.println("Đã thêm user hợp lệ.");

            String insert2 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            stmt2 = conn.prepareStatement(insert2);
            stmt2.setInt(1, 1);
            stmt2.setString(2, "Tran Van B");
            stmt2.setString(3, "b@example.com");
            stmt2.executeUpdate();

            conn.commit();
            System.out.println("Commit thành công.");
        } catch (SQLException e) {
            System.out.println("Lỗi xảy ra, rollback lại toàn bộ thao tác.");
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Rollback thành công.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (stmt1 != null) stmt1.close();
                if (stmt2 != null) stmt2.close();
                if (conn != null) conn.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        verifyNoData();
    }

    public static void verifyNoData() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ss28",
                "root", "265205")) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            System.out.println("Dữ liệu trong bảng users:");
            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email"));
            }

            if (!hasData) {
                System.out.println("Không có dữ liệu nào trong bảng.");
            }

        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }
}
