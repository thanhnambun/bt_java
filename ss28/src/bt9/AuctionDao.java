package bt9;

public interface AuctionDao {
    int placeBid(int userId, int auctionId, double bidAmount);
}
