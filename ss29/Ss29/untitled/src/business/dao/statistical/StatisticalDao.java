package business.dao.statistical;

import business.model.Employess;

import java.util.List;

public interface StatisticalDao {
    List<Employess> goupbyDepartment();
    int sum_empl();
    int department_max_empl();
    int sum_max_salary();
}
