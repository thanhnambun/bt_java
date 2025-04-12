package business.dao.employ;

import business.config.ConnectionDB;
import business.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements  EmployeeDao {
    public int getTotalEmployessPages() {
        Connection conn = null;
        CallableStatement stmt = null;
        int totalPages = 0;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call get_total_empl_pages()}");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalPages = rs.getInt("total_pages");
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return totalPages;
    }
    @Override
    public List<Employess> getEmployeesByPage(int page) {
        List<Employess> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call list_employees_by_page(?)}");
            stmt.setInt(1, page);
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
    public boolean addEmployee(Employess emp) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call save_employee(?,?,?,?,?,?,?,?,?,?)}");
            stmt.setString(1, emp.getNameEmployess());
            stmt.setString(2, emp.getEmailEmployess());
            stmt.setString(3, emp.getPhoneEmployess());
            stmt.setString(4, emp.getSex().name());
            stmt.setInt(5, emp.getLevelEmployess());
            stmt.setDouble(6, emp.getSalaryEmployess());
            stmt.setDate(7, Date.valueOf(emp.getBirthdayEmployess()));
            stmt.setString(8, emp.getAddressEmployess());
            stmt.setString(9, emp.getStatusEmployess().name());
            stmt.setInt(10, emp.getDepartmentID());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employess emp) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call UpdateEmployee(?,?,?,?,?,?,?,?,?,?)}");
            stmt.setString(1, emp.getIdEmployess());
            stmt.setString(2, emp.getNameEmployess());
            stmt.setString(3, emp.getEmailEmployess());
            stmt.setString(4, emp.getPhoneEmployess());
            stmt.setString(5, emp.getSex().name());
            stmt.setDouble(6, emp.getSalaryEmployess());
            stmt.setInt(7, emp.getLevelEmployess());
            stmt.setDate(8, Date.valueOf(emp.getBirthdayEmployess()));
            stmt.setString(9, emp.getAddressEmployess());
            stmt.setString(10, emp.getStatusEmployess().name());
            stmt.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.fillInStackTrace();
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call delete_empl(?)}");
            stmt.setString(1, id);
            stmt.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.fillInStackTrace();
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return false;
    }

    @Override
    public List<Employess> searchByAge( int minAge, int maxAge) {
        List<Employess> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call search_empl_by_age(?,?)}");
            stmt.setInt(1, minAge);
            stmt.setInt(2, maxAge);
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
    public List<Employess> searchByName(String name) {
        List<Employess> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call search_empl_by_name(?)}");
            stmt.setString(1, name);
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
    public List<Employess> sortBySalaryDesc() {
        List<Employess> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call sort_empl_by_salary()}");
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
    public List<Employess> sortByNameAsc() {
        List<Employess> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call sort_empl_by_name()}");
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
    public Employess getEmployeeById(String id) {
        Connection conn = null;
        CallableStatement stmt = null;
        Employess emp = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call find_emp_by_id(?)}");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                emp = new Employess();
                emp.setIdEmployess(rs.getString("employee_id"));
                emp.setNameEmployess(rs.getString("name"));
                emp.setEmailEmployess(rs.getString("email"));
                emp.setPhoneEmployess(rs.getString("phone"));
                emp.setSex(Sex.valueOf(rs.getString("gender")));
                emp.setLevelEmployess(rs.getInt("level"));
                emp.setSalaryEmployess(rs.getDouble("salary"));
                emp.setBirthdayEmployess(rs.getDate("birthdate").toLocalDate());
                emp.setAddressEmployess(rs.getString("address"));
                emp.setStatusEmployess(StatusEmployess.valueOf(rs.getString("status")));
                emp.setDepartmentID(rs.getInt("department_id"));
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return emp;
    }
}
