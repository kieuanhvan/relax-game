package DATABASE_MANAGERMENT;

import Streamer.PlayerCaro;
import Streamer.PlayerSnake;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieu anh văn
 */
public class ManagerDataBase {

    private static final String user = "sa";
    private static final String password = "1234567890van";
    private static final String sever = "KIEU-ANH-VAN\\SQLEXPRESS";
    private static final int port = 1433;
    private static final String database_name = "quanlybanhang";
    private static ArrayList<PlayerSnake> list = list = new ArrayList<>();

    ;

    public static SQLServerDataSource configDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDatabaseName(database_name);
        dataSource.setPortNumber(port);
        dataSource.setServerName(sever);
        return dataSource;
    }

    public static int insertDataByPrepareStatement(PlayerSnake p) throws Exception {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "insert into PLAYER_SNAKE (NICKNAME , PASSWORDS ,EMAIL ) values "
                    + "(? , ? , ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getFullName());
            ps.setString(2, p.getPassword());
            ps.setString(3, p.getEmail());
            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            throw new Exception("Lỗi ID đã tồn tại");
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBase.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static void loadData(ArrayList<PlayerSnake> list) {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "Select * from danhmuc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                System.out.println(result.getString(1));
            }
        } catch (SQLServerException ex) {
     
            System.out.println("error");
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }
    public static void main(String[] args) {
        loadData(null);
    }



//    public static int UpdateByPrepareStatement(PlayerSnake student) {
//        SQLServerDataSource dataSource = configDataSource();
//        try ( Connection conn = dataSource.getConnection()) {
//            String sql = "update student set fullname = ? , email = ?,"
//                    + " phone_number = ? , gender = ? , address_v = ?"
//                    + " where id = ?;";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, student.getFullName());
//            ps.setString(2, student.getEmail());
//            ps.setString(3, student.getPhoneNumber());
//            ps.setString(4, student.getGender());
//            ps.setString(5, student.getAddress());
//            ps.setString(6, student.getId());
//            return ps.executeUpdate();
//        } catch (SQLServerException ex) {
//            Logger.getLogger(ManagerDataBase.class.getName()).log(Level.SEVERE, null, ex);
//            return -1;
//        } catch (SQLException ex) {
//            Logger.getLogger(ManagerDataBase.class.getName()).log(Level.SEVERE, null, ex);
//            return -1;
//        }
//    }

}
