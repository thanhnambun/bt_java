import java.sql.*;

public class Bt1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String jdbcUrl = "jdbc:mysql://localhost:3306/ss28";
        String username = "root";
        String password = "265205";

        try {
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Kết nối thành công đến cơ sở dữ liệu!");

            boolean isAutoCommit = conn.getAutoCommit();
            System.out.println("Trạng thái auto-commit ban đầu: " + isAutoCommit);

            conn.setAutoCommit(false);
            System.out.println("Auto-commit đã được tắt.");

            String insertSQL = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(insertSQL);
            stmt.setInt(1, 1);
            stmt.setString(2, "Nguyen Van A");
            stmt.setString(3, "a.nguyen@example.com");
            int rows = stmt.executeUpdate();

            conn.commit();
            System.out.println("Đã commit thành công. Số dòng thêm vào: " + rows);

            Statement checkStmt = conn.createStatement();
            ResultSet rs = checkStmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Email: " + rs.getString("email"));
            }

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Lỗi xảy ra! Đã rollback.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
