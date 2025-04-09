import java.sql.*;

public class bt3 {
    public static void main(String[] args) {
        int fromAccountId = 1;
        int toAccountId = 2;
        double amount = 1000;

        String jdbcUrl = "jdbc:mysql://localhost:3306/Banking_DB";
        String username = "root";
        String password = "265205";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            conn.setAutoCommit(false);

            double senderBalance = getBalance(conn, fromAccountId);
            if (senderBalance < amount) {
                throw new SQLException("Không đủ số dư để chuyển tiền.");
            }

            updateBalance(conn, fromAccountId, -amount);

            updateBalance(conn, toAccountId, amount);

            conn.commit();
            System.out.println("Chuyển tiền thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi chuyển tiền: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Đã rollback thay đổi.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.close();
                System.out.println("Đóng kết nối.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static double getBalance(Connection conn, int accountId) throws SQLException {
        String sql = "SELECT balance FROM accounts WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            } else {
                throw new SQLException("Không tìm thấy tài khoản ID = " + accountId);
            }
        }
    }

    private static void updateBalance(Connection conn, int accountId, double amount) throws SQLException {
        String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Không cập nhật được tài khoản ID = " + accountId);
            }
        }
    }
}
