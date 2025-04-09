import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Bt6 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/CompanyDB";
        String user = "root";
        String password = "265205";

        Connection conn = null;
        PreparedStatement insertDept = null;
        PreparedStatement insertEmp = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            String sqlDept = "INSERT INTO departments (name) VALUES (?)";
            insertDept = conn.prepareStatement(sqlDept, Statement.RETURN_GENERATED_KEYS);
            insertDept.setString(1, "Phòng Công Nghệ");
            insertDept.executeUpdate();

            rs = insertDept.getGeneratedKeys();
            int deptId = 0;
            if (rs.next()) {
                deptId = rs.getInt(1);
            }

            String sqlEmp = "INSERT INTO employees (name, department_id) VALUES (?, ?)";
            insertEmp = conn.prepareStatement(sqlEmp);

            List<String> employees = Arrays.asList("Nam", "Linh", null);

            for (String empName : employees) {
                insertEmp.setString(1, empName);
                insertEmp.setInt(2, deptId);
                insertEmp.executeUpdate();
            }

            conn.commit();
            System.out.println("Giao dịch thành công!");

        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra. Rollback...");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.fillInStackTrace();
            }
            e.fillInStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if (insertEmp != null) insertEmp.close(); } catch (SQLException ignored) {}
            try { if (insertDept != null) insertDept.close(); } catch (SQLException ignored) {}
            try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
        }
    }
}
