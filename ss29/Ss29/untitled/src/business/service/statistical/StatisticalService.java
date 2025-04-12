package business.service.statistical;

import business.model.Employess;

import java.util.List;

public interface StatisticalService {
    List<Employess> goupbyDepartment();
    int sum_empl();
    int department_max_empl();
    int sum_max_salary();
}
