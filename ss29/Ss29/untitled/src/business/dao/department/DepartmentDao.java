package business.dao.department;

import business.model.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> getall();
    int getTotalDepartmentPages();
    List<Department> getDepartmentsByPage(int id );
    Department getById(int id);
    boolean addDepartment(Department department);
    boolean update(Department department);
    boolean delete(Department department);
    List<Department> sreach(String name);
    int searchEmployess(int id);
}
