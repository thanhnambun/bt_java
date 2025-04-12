package business.service.department;

import business.dao.department.DepartmentDao;
import business.dao.department.DepartmentDaoImp;
import business.model.Department;

import java.util.List;

public class DerpartmentServiceImp implements DepartmentService {
    private final DepartmentDao departmentDao;

    public DerpartmentServiceImp() {
        departmentDao = new DepartmentDaoImp();
    }

    @Override
    public List<Department> getall() {
        return departmentDao.getall();
    }

    @Override
    public int getTotalDepartmentPages() {
        return departmentDao.getTotalDepartmentPages();
    }

    @Override
    public List<Department> getDepartmentsByPage(int id) {
        return departmentDao.getDepartmentsByPage(id);
    }

    @Override
    public Department getById(int id) {
        return departmentDao.getById(id);
    }

    @Override
    public boolean addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public boolean update(Department department) {
        return departmentDao.update(department);
    }

    @Override
    public boolean delete(Department department) {
        return departmentDao.delete(department);
    }

    @Override
    public List<Department> sreach(String name) {
        return departmentDao.sreach(name);
    }

    @Override
    public int searchEmployess(int id) {
        return departmentDao.searchEmployess(id);
    }

}
