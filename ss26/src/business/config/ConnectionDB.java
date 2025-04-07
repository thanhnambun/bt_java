package business.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String DRIVER = "";
    private static String URL = "jdbc:mysql://localhost:3306/studentmanagement";
    private static String USERNAME = "root";
    private static String PASSWORD = "265205";

    public static Connection openConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        }catch (SQLException e){
            System.err.println(" lỗi trong quá trình kết nôối " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("lỗi "+e.getMessage());
        }
        return con;
    }
    public static void closeConnection(Connection con, CallableStatement  call) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw  new RuntimeException(e);
            }
        }
        if (call != null) {
            try {
                call.close();
            } catch (SQLException e) {
                throw  new RuntimeException(e);
            }
        }
    }
}
