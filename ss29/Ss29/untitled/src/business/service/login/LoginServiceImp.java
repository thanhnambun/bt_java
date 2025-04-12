package business.service.login;

import business.dao.Account.login.LoginDao;
import business.dao.Account.login.LoginDaoImp;
import business.model.Account;

public class LoginServiceImp {
    private final LoginDao loginDao;

    public LoginServiceImp() {
         loginDao = new LoginDaoImp();
    }
    public Account login(String username, String password) {
        return loginDao.login(username, password);
    }
}
