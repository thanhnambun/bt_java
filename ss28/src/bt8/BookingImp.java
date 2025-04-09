package bt8;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

class BookingImp implements BookingDao {

    @Override
    public int bookRoom(int customerId, int roomId) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);

            callSt = conn.prepareCall("{call book_room(?, ?, ?)}");
            callSt.setInt(1, customerId);
            callSt.setInt(2, roomId);
            callSt.registerOutParameter(3, Types.INTEGER);

            callSt.execute();
            conn.commit();

            int result = callSt.getInt(3);
            switch (result) {
                case -1:
                    System.err.println("Khách hàng không tồn tại.");
                    break;
                case -2:
                    System.err.println("Phòng đã được đặt.");
                    break;
                case 1:
                    System.out.println("Đặt phòng thành công.");
                    break;
            }

            return result;

        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra, dữ liệu đã được rollback.");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException("Rollback failed: " + ex.getMessage());
            }
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }
}
