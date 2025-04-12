package business.dao.Account.login;

import business.config.ConnectionDB;
import business.model.Account;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImp implements LoginDao {
    @Override
    public Account login(String username, String password) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call login_acc(?,?)}");
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                return account;
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e) {
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return null;
    }

}
