package business.service.employe;

import business.model.Employess;

import java.util.List;

public interface EmployeesService {
    int getTotalEmployessPages();
    List<Employess> getEmployeesByPage(int page);
    boolean addEmployee(Employess employee);
    boolean updateEmployee(Employess employee);
    boolean deleteEmployee(String id);
    List<Employess> searchByAge(int minAge, int maxAge);
    List<Employess> searchByName(String name);
    List<Employess> sortBySalaryDesc();
    List<Employess> sortByNameAsc();
    Employess getEmployeeById(String id);
}
