package business.service.login;

import business.model.Account;

public interface LoginService {
    Account login(String username, String password);
}
