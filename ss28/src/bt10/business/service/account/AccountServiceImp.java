package bt10.business.service.account;

import bt10.business.dao.account.AccountDao;
import bt10.business.dao.account.AccountDaoImp;
import bt10.business.model.Account;

import java.util.List;

public class AccountServiceImp implements AccountService<Account> {
    private final AccountDao accountDao;

    public AccountServiceImp() {
        accountDao = new AccountDaoImp();
    }

    @Override
    public List<Account> getAll() {
        return accountDao.getAll();
    }

    @Override
    public boolean save(Account account) {
        return accountDao.save(account);
    }

    @Override
    public boolean update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public boolean delete(Account account) {
        return accountDao.delete(account);
    }

    @Override
    public int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount) {
        return accountDao.fundsTransfer(accSenderId, accSenderName, accReceiverId, accReceiverName, amount);
    }

    @Override
    public Account getBalanceByAccountId(int accId) {
        return (Account) accountDao.getBalanceByAccountId(accId);
    }
}
