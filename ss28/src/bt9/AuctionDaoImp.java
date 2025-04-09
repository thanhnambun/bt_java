package bt9;


import java.sql.*;

public class AuctionDaoImp implements AuctionDao {
    @Override
    public int placeBid(int userId, int auctionId, double bidAmount) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            callSt = conn.prepareCall("{call place_bid(?, ?, ?, ?)}");
            callSt.setInt(1, userId);
            callSt.setInt(2, auctionId);
            callSt.setDouble(3, bidAmount);
            callSt.registerOutParameter(4, Types.INTEGER);

            callSt.execute();
            conn.commit();

            int result = callSt.getInt(4);
            switch (result) {
                case -1:
                    System.err.println("Người dùng không tồn tại hoặc số dư không đủ.");
                    break;
                case -2:
                    System.err.println("Giá đặt thấp hơn giá cao nhất hiện tại.");
                    break;
                case 1:
                    System.out.println("Đặt giá thành công.");
                    break;
            }

            return result;

        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra khi đặt giá, dữ liệu đã được rollback.");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException("Rollback thất bại: " + ex.getMessage());
            }
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }
}

