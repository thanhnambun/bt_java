package business.service.employe;

import business.dao.employ.EmployeeDao;
import business.dao.employ.EmployeeDaoImp;
import business.model.Employess;

import java.util.List;

public class EmployeesServiceImp implements EmployeesService {
    private final EmployeeDao employeeDao;
    public EmployeesServiceImp() {
        employeeDao = new EmployeeDaoImp();
    }
    @Override
    public int getTotalEmployessPages() {
        return employeeDao.getTotalEmployessPages();
    }

    @Override
    public List<Employess> getEmployeesByPage(int page) {
        return employeeDao.getEmployeesByPage(page);
    }

    @Override
    public boolean addEmployee(Employess employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employess employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(String id) {
        return employeeDao.deleteEmployee(id);
    }

    @Override
    public List<Employess> searchByAge(int minAge, int maxAge) {
        return employeeDao.searchByAge(minAge, maxAge);
    }

    @Override
    public List<Employess> searchByName(String name) {
        return employeeDao.searchByName(name);
    }

    @Override
    public List<Employess> sortBySalaryDesc() {
        return employeeDao.sortBySalaryDesc();
    }

    @Override
    public List<Employess> sortByNameAsc() {
        return employeeDao.sortByNameAsc();
    }

    @Override
    public Employess getEmployeeById(String id) {
        return employeeDao.getEmployeeById(id);
    }
}
