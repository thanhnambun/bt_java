package bt10.business.dao.funs_transfer;

import bt10.business.model.FunsTransfer;

import java.util.Date;
import java.util.List;

public interface Funs_transferDao {
    List<FunsTransfer> getTransferHistory();
    double getTotalTransferredBetweenDates(Date fromDate, Date toDate);
    double getTotalReceivedByAccount(int accReceiverId);
   int getCountTransfer(Date fromDate, Date toDate);
}
