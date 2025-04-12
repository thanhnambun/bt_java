package business.dao.department;

import business.config.ConnectionDB;
import business.model.Department;
import business.model.Status;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImp implements DepartmentDao  {

    @Override
    public List<Department> getall() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Department> departmentList = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call get_all()}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setNameDepartment(rs.getString("name"));
                department.setDescription(rs.getString("description"));
                department.setStatusDepartment(Status.valueOf(rs.getString("status")));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return departmentList;
    }

    @Override
    public int getTotalDepartmentPages() {
        Connection conn = null;
        CallableStatement stmt = null;
        int totalPages = 0;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call get_total_department_pages()}");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalPages = rs.getInt("total_pages");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return totalPages;
    }

    @Override
    public List<Department> getDepartmentsByPage(int page) {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Department> departmentList = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call list_department(?)}");
            stmt.setInt(1, page);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setNameDepartment(rs.getString("name"));
                department.setDescription(rs.getString("description"));
                department.setStatusDepartment(Status.valueOf(rs.getString("status")));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return departmentList;
    }


    @Override
    public Department getById(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        Department department = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call get_department_by_id(?)}");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                department = new Department();
                department.getIdDepartment();
                department.setNameDepartment(rs.getString("name"));
                department.setDescription(rs.getString("description"));
                department.setStatusDepartment(Status.valueOf(rs.getString("status")));
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return department;
    }


    @Override
    public boolean addDepartment(Department department) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call save_department(?,?,?)}");
            stmt.setString(1, department.getNameDepartment());
            stmt.setString(2, department.getDescription());
            stmt.setString(3, department.getStatusDepartment().name());
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean update(Department department) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call update_department_name(?,?,?)}");
            stmt.setInt(1, department.getIdDepartment());
            stmt.setString(2, department.getNameDepartment());
            stmt.setString(3,department.getStatusDepartment().name());
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean delete(Department department) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call delete_acc(?)}");
            stmt.setInt(1, department.getIdDepartment());
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public List<Department> sreach(String name) {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Department> departmentList = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call search_department(?)}");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            departmentList = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department();
                department.setNameDepartment(rs.getString("name"));
                department.setDescription(rs.getString("description"));
                department.setStatusDepartment(Status.valueOf(rs.getString("status")));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return departmentList;
    }

    @Override
    public int searchEmployess(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call search_emp_from_dept(?,?)}");
            stmt.setInt(1, id);
            stmt.registerOutParameter(2, java.sql.Types.INTEGER);
            stmt.execute();
            return stmt.getInt(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return 0;
    }

}
