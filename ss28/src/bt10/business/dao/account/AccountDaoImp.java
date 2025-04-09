package bt10.business.dao.account;

import bt10.business.config.ConnectionDB;
import bt10.business.model.Account;
import bt10.business.model.AccountStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImp implements AccountDao<Account> {
    @Override
    public List getAll() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Account> listAccount = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call find_all_list_acc}");
            ResultSet rs = stmt.executeQuery();
            listAccount = new ArrayList<Account>();
            while (rs.next()) {
                Account account = new Account();
                account.setAccId(rs.getInt("acc_id"));
                account.setAccName(rs.getString("acc_name"));
                account.setBalance(rs.getDouble("balance"));
                account.setStatus(AccountStatus.valueOf("active"));
                listAccount.add(account);
            }
        }
        catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return listAccount;
    }

    @Override
    public boolean save(Account account) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call add_acc(?,?,?)}");
            stmt.setString(1, account.getAccName());
            stmt.setDouble(2, account.getBalance());
            stmt.setString(3, account.getStatus().name());
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean update(Account account) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call update_acc(?,?,?)}");
            stmt.setInt(1, account.getAccId());
            stmt.setString(2, account.getAccName());
            stmt.setString(3, account.getStatus().name());
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean delete(Account account) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call delete_acc(?)}");
            stmt.setInt(1, account.getAccId());
            stmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn.setAutoCommit(false);
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call funs_transfer_amount(?,?,?,?,?,?)}");
            callSt.setInt(1, accSenderId);
            callSt.setString(2, accSenderName);
            callSt.setInt(3, accReceiverId);
            callSt.setString(4, accReceiverName);
            callSt.setDouble(5, amount);
            callSt.registerOutParameter(6, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(6);
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return 0;
    }

    @Override
    public Account getBalanceByAccountId(int accId) {
        Connection conn = null;
        CallableStatement stmt = null;
        Account  account = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt =  conn.prepareCall("{call find_balance_by_Id(?)}");
            stmt.setInt(1, accId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                account = new Account();
                account.setAccId(rs.getInt("acc_id"));
                account.setAccName(rs.getString("acc_name"));
                account.setBalance(rs.getDouble("balance"));
                account.setStatus(AccountStatus.valueOf("active"));
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return account;
    }
}
