package business.dao.Account.login;

import business.model.Account;

public interface LoginDao {
    Account login(String username, String password);
}
