package bt10.business.dao.funs_transfer;

import bt10.business.config.ConnectionDB;
import bt10.business.model.FunsTransfer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funs_transferDaoImp implements Funs_transferDao {

    @Override
    public List<FunsTransfer> getTransferHistory() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<FunsTransfer> funsTransfers = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{?=call find_all_funs()");
            ResultSet rs = stmt.executeQuery();
            funsTransfers = new ArrayList<FunsTransfer>();
            while (rs.next()) {
                FunsTransfer funsTransfer = new FunsTransfer();
                funsTransfer.setAccId(rs.getInt("acc_id"));
                funsTransfer.setAccSenderName(rs.getString("acc_sender_name"));
                funsTransfer.setAccReceiverName(rs.getString("acc_receiver_name"));
                funsTransfer.setAmount(rs.getDouble("amount"));
                funsTransfer.setDate(rs.getDate("date"));
                funsTransfer.setStatus(rs.getBoolean("status"));
                funsTransfers.add(funsTransfer);
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e ){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return funsTransfers;
    }

    @Override
    public double getTotalTransferredBetweenDates(Date fromDate, Date toDate) {
        Connection conn = null;
        CallableStatement stmt = null;
        double amount =0;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{?=call amount_fromDate_toDate(?,?,?)}");
            stmt.setDate(1, new java.sql.Date(fromDate.getTime()));
            stmt.setDate(2, new java.sql.Date(toDate.getTime()));
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                 amount = rs.getDouble("amount");
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return amount;
    }

    @Override
    public double getTotalReceivedByAccount(int accReceiverId) {
        Connection conn = null;
        CallableStatement stmt = null;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{?=call amount_By_account(?,?)}");
            stmt.setInt(1, accReceiverId);
            stmt.registerOutParameter(2, java.sql.Types.DOUBLE);
            stmt.executeQuery();
            return stmt.getDouble(2);
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return 0;
    }

    @Override
    public int getCountTransfer(Date fromDate, Date toDate) {
        Connection conn = null;
        CallableStatement stmt = null;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{?=call successful_transaction(?,?,?)}");
            stmt.setDate(1, new java.sql.Date(fromDate.getTime()));
            stmt.setDate(2, new java.sql.Date(toDate.getTime()));
            stmt.registerOutParameter(3, Types.INTEGER);
            stmt.executeQuery();
            return stmt.getInt(3);
        }catch (SQLException e){
            e.fillInStackTrace();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return 0;
    }
}
