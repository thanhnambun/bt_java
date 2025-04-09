package bt7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/IsolationTestDB";
        String user = "root";
        String password = "your_password"; // thay bằng mật khẩu thực tế
        return DriverManager.getConnection(url, user, password);
    }
}

