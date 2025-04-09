package bt10.business.service.funsTransfer;

import bt10.business.dao.funs_transfer.Funs_transferDao;
import bt10.business.dao.funs_transfer.Funs_transferDaoImp;
import bt10.business.model.FunsTransfer;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FunsTranferServicImp implements FunsTransferService {
    private final Funs_transferDao funsTransferDaoImpansfer;

    public FunsTranferServicImp() {
        funsTransferDaoImpansfer = new Funs_transferDaoImp();
    }

    @Override
    public List<FunsTransfer> getTransferHistory() {
        return funsTransferDaoImpansfer.getTransferHistory();
    }

    @Override
    public double getTotalTransferredBetweenDates(Date fromDate, Date toDate) {
        return funsTransferDaoImpansfer.getTotalTransferredBetweenDates(fromDate, toDate);
    }

    @Override
    public double getTotalReceivedByAccount(int accReceiverId) {
        return funsTransferDaoImpansfer.getTotalReceivedByAccount(accReceiverId);
    }

    @Override
    public int getCountTransfer(Date fromDate, Date toDate) {
        return funsTransferDaoImpansfer.getCountTransfer(fromDate, toDate);
    }
}
