package bt10.business.service.funsTransfer;

import bt10.business.model.FunsTransfer;

import java.util.Date;
import java.util.List;

public interface FunsTransferService {
    List<FunsTransfer> getTransferHistory();
    double getTotalTransferredBetweenDates(Date fromDate, Date toDate);
    double getTotalReceivedByAccount(int accReceiverId);
    int getCountTransfer(Date fromDate, Date toDate);
}
