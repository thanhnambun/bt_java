package bt10.business.model;

import java.util.Date;

public class FunsTransfer {
    private int  accId;
    private String accSenderName;
    private String accReceiverName;
    private double amount;
    private Date date;
    private boolean status;

    public FunsTransfer() {
    }

    public FunsTransfer(int accId, String accSenderName, String accReceiverName, double amount, Date date, boolean status) {
        this.accId = accId;
        this.accSenderName = accSenderName;
        this.accReceiverName = accReceiverName;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getAccSenderName() {
        return accSenderName;
    }

    public void setAccSenderName(String accSenderName) {
        this.accSenderName = accSenderName;
    }

    public String getAccReceiverName() {
        return accReceiverName;
    }

    public void setAccReceiverName(String accReceiverName) {
        this.accReceiverName = accReceiverName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FunsTransfer{" +
                "accId=" + accId +
                ", accSenderName='" + accSenderName + '\'' +
                ", accReceiverName='" + accReceiverName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
