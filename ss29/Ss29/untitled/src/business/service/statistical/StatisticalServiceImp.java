package business.service.statistical;

import business.dao.statistical.StatisticalDao;
import business.dao.statistical.StatisticalDaoImp;
import business.model.Employess;

import java.util.List;

public class StatisticalServiceImp implements StatisticalService {
    private final StatisticalDao statisticalDao;

    public StatisticalServiceImp() {
        statisticalDao = new StatisticalDaoImp();
    }

    @Override
    public List<Employess> goupbyDepartment() {
        return statisticalDao.goupbyDepartment();
    }

    @Override
    public int sum_empl() {
        return statisticalDao.sum_empl();
    }

    @Override
    public int department_max_empl() {
        return statisticalDao.department_max_empl();
    }

    @Override
    public int sum_max_salary() {
        return statisticalDao.sum_max_salary();
    }
}
