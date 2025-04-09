package bt10.business.service.account;

import bt10.business.service.AppService;

import java.util.List;

public interface AccountService<T> extends AppService {
    List<T> getAll();
    boolean save(T t);
    boolean update(T t);
    boolean delete(T t);
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
    T getBalanceByAccountId(int accId);
}
