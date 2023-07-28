package ManagerDataBase;

/**
 *
 * @author kieu anh văn
 */
import static ManagerDataBase.ManagerDataBaseStudent.configDataSource;
import Objects.User;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author kieu anh văn
 */
public class ManagerDataBaseUser {

    private static final String user = "sa";
    private static final String password = "1234567890van";
    private static final String sever = "KIEU-ANH-VAN\\SQLEXPRESS";
    private static final int port = 1433;
    private static final String database_name = "MANAGER_OBJECT";

    public static SQLServerDataSource configDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDatabaseName(database_name);
        dataSource.setPortNumber(port);
        dataSource.setServerName(sever);
        return dataSource;
    }

    public static int insertDataByPrepareStatement(User user) throws Exception {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "insert into users (username ,passwords , roles) values "
                    + "(? , ? , ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());

            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            throw new Exception("Lỗi ID đã tồn tại");
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
   static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static void loadData(ArrayList<User> list) {
        list.clear();   
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "Select * from users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String username = result.getString(1);
                String passwords = result.getString(2);
                String roles = result.getString(3);
                String gmail = result.getString(4);
                String gender = result.getString(5);
                String birtdDayChecken = result.getString(6);
                Date birthday =   dateFormat.parse((birtdDayChecken == null)?  "0000-00-00" :birtdDayChecken);
                User u = new User(username, passwords, roles, gmail, gender,  birthday);
                list.add(u);
            }
         
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManagerDataBaseUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int UpdateByPrepareStatement(User u) {
        System.out.println(dateFormat.format(u.getBirthday()));
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "update Users set gmail = ? , gender = ? , Birthday = ? where username = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getGmail());
            ps.setString(2, u.getGender());
            ps.setString(3, dateFormat.format(u.getBirthday()));
            ps.setString(4, u.getFullName());
            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    public static int updatePass(User u) {
        System.out.println(dateFormat.format(u.getBirthday()));
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "update users set passwords = ? where username = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getPassword());
            ps.setString(2, u.getFullName());

            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
