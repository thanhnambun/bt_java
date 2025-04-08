package business.dao.student;

import business.config.ConnectionDB;
import business.model.Student;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements StudentDAO {

    @Override
    public int getCountStudentByStatus(boolean status) {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Student> students = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt =  conn.prepareCall("{call student_count_by_status(?,?)}");
            cstmt.setBoolean(1, status);
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            return cstmt.getInt(2);
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,cstmt);
        }
        return 0;
    }

    @Override
    public Student findById(int id) {
        Connection conn = null;
        CallableStatement call = null;
        Student student = null;
        try {
            conn = ConnectionDB.openConnection();
            call = conn.prepareCall("{call findById(?)}");
            call.setInt(1, id);
            ResultSet rs= call.executeQuery();
            student = new Student();
            if (rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setStatus(rs.getBoolean("status"));
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(conn,call);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Student> students = null;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{ call find_all_student()}");
            ResultSet rs = callStmt.executeQuery();
            students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setName(rs.getString("student_name"));
                student.setAge(rs.getInt("student_age"));
                student.setStatus(rs.getBoolean("student_status"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return students;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("call create_student(?,?,?)");
            callStmt.setString(1, student.getName());
            callStmt.setInt(2, student.getAge());
            callStmt.setBoolean(3, student.isStatus());
            callStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("call update_student(?,?,?,?)");
            callStmt.setInt(1, student.getId());
            callStmt.setString(2, student.getName());
            callStmt.setInt(3, student.getAge());
            callStmt.setBoolean(4, student.isStatus());
            callStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        Connection conn = null;
        CallableStatement callS = null;
        try {
            conn = ConnectionDB.openConnection();
            callS = conn.prepareCall("call delete_student(?)");
            callS.setInt(1, student.getId());
            callS.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callS);
        }
        return false;
    }
}
