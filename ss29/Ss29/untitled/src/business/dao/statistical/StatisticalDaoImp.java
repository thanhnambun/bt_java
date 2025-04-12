package business.dao.statistical;

import business.config.ConnectionDB;
import business.model.Employess;
import business.model.Sex;
import business.model.StatusEmployess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatisticalDaoImp implements StatisticalDao {
    @Override
    public List<Employess> goupbyDepartment() {
        List<Employess> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call goupby_department()}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Employess e = new Employess();
                e.setIdEmployess(rs.getString("employee_id"));
                e.setNameEmployess(rs.getString("name"));
                e.setEmailEmployess(rs.getString("email"));
                e.setPhoneEmployess(rs.getString("phone"));
                e.setSex(Sex.valueOf(rs.getString("gender")));
                e.setLevelEmployess(rs.getInt("level"));
                e.setSalaryEmployess(rs.getDouble("salary"));
                e.setBirthdayEmployess(rs.getDate("birthdate").toLocalDate());
                e.setAddressEmployess(rs.getString("address"));
                e.setStatusEmployess(StatusEmployess.valueOf(rs.getString("status")));
                e.setDepartmentID(rs.getInt("department_id"));
                list.add(e);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return list;
    }

    @Override
    public int sum_empl() {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call sum_empl()}");
            stmt.execute();
            return stmt.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return 0;
    }

    @Override
    public int department_max_empl() {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call department_max_empl()}");
            stmt.execute();
            return stmt.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return 0;
    }

    @Override
    public int sum_max_salary() {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call sum_max_salary()}");
            stmt.execute();
            return stmt.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return 0;
    }
}
