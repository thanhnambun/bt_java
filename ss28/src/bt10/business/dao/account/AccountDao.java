package bt10.business.dao.account;

import bt10.business.dao.AppDao;

import java.util.List;

public interface AccountDao<T> extends AppDao {
    List<T> getAll();
    boolean save(T t);
    boolean update(T t);
    boolean delete(T t);
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
    T getBalanceByAccountId(int accId);
}
