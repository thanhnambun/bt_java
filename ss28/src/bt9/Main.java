package bt9;

public class Main {
    public static void main(String[] args) {
        AuctionDaoImp auctionDao = new AuctionDaoImp();
        auctionDao.placeBid(3,1,30);
        auctionDao.placeBid(1,1,35);
    }
}
