package ManagerDataBase;

import Objects.Grades;
import Objects.Student;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieu anh văn
 */
public class ManagerDataBaseStudent {

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

    public static int insertDataByPrepareStatement(Student student) throws Exception {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "insert into student "
                    + " (masv , fullname ,email , phonenumber, gender,address_st,image_st) values  "
                    + " (? , ? , ? , ? , ? , ? , ?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getMasv());
            ps.setString(2, student.getFullName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhoneNumber());
            ps.setInt(5, ChangeGender(student.isGender()));
            ps.setString(6, student.getAddress());
            ps.setString(7, student.getPathImage());
            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            throw new Exception("Lỗi ID đã tồn tại");
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static void loadData(DefaultTableModel tableModel, ArrayList<Student> list) {
        if (tableModel != null) {
            tableModel.setRowCount(0);
        }
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "Select * from STUDENT";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String fullName = result.getString(2);
                String email = result.getString(3);
                String phoneNumber = result.getString(4);
                int gender = result.getInt(5);
                String address = result.getString(6);
                String pathImage = result.getString(7);
                if (tableModel != null) {
                    tableModel.addRow(new Object[]{
                        id, fullName, email, phoneNumber, getGender(gender), address, pathImage
                    });
                }
                if (list != null) {
                    Student student = new Student(id, fullName, email, phoneNumber, (gender == 1) ? true : false, address, pathImage);
                    list.add(student);
                }
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadDataGrade(DefaultTableModel tableModel, ArrayList<Grades> list) {
        tableModel.setRowCount(0);
        list.clear();
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "SELECT GRADE.MASV_FK , STUDENT.FULLNAME, GRADE.ENGLISH , "
                    + " GRADE.TINHOC , GRADE.GDTC FROM GRADE\n"
                    + " inner join student on grade.masv_fk = student.masv; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String fullName = result.getString(2);
                String english = result.getString(3);
                String tinhoc = result.getString(4);
                String gdtc = result.getString(5);
                String avgGrades = caculator(english, tinhoc, gdtc);
                tableModel.addRow(new Object[]{
                    id, fullName, english, tinhoc, gdtc, avgGrades
                });
                Grades g = new Grades(id, fullName, Float.valueOf(english), Float.valueOf(tinhoc), Float.valueOf(gdtc));
                list.add(g);
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadDataGrade_WhenStudentGotGrade(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "select * from GRADE where ENGLISH is not null AND TINHOC is not null AND GDTC is not null;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String id = result.getString(2);
                String fullName = result.getString(3);
                String english = result.getString(4);
                String tinhoc = result.getString(5);
                String gdtc = result.getString(6);
                String avgGrades = caculator(english, tinhoc, gdtc);
                tableModel.addRow(new Object[]{
                    id, fullName, english, tinhoc, gdtc, avgGrades
                });
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadDataGrade_WhenStudentNotGrade(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "select * from GRADE where ENGLISH is null or TINHOC is null or GDTC is null;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String id = result.getString(2);
                String fullName = result.getString(3);
                String english = result.getString(4);
                String tinhoc = result.getString(5);
                String gdtc = result.getString(6);
                String avgGrades = caculator(english, tinhoc, gdtc);
                tableModel.addRow(new Object[]{
                    id, fullName, english, tinhoc, gdtc, avgGrades
                });
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadDataGrade_WithTop(DefaultTableModel tableModel, int num) {
        tableModel.setRowCount(0);
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "select GRADE.MASV_FK , STUDENT.FULLNAME ,GRADE.ENGLISH, "
                    + "GRADE.TINHOC ,GRADE.GDTC from grade \n "
                    + " inner join student on student.masv = grade.masv_fk\n "
                    + " where ((ENGLISH + TINHOC + GDTC)/3) in \n "
                    + "                     (select top (?)  ((ENGLISH + TINHOC + GDTC)/3) from grade\n "
                    + "                     group by ((ENGLISH + TINHOC + GDTC)/3)\n"
                    + "                    )\n "
                    + "                     order by ((ENGLISH + TINHOC + GDTC)/3) desc; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String fullName = result.getString(2);
                String english = result.getString(3);
                String tinhoc = result.getString(4);
                String gdtc = result.getString(5);
                String avgGrades = caculator(english, tinhoc, gdtc);
                tableModel.addRow(new Object[]{
                    id, fullName, english, tinhoc, gdtc, avgGrades
                });
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int UpdateByPrepareStatement(Student student) {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "update student set fullname = ? , email = ?,"
                    + " phonenumber = ? , gender = ? , address_st = ?,"
                    + " image_st = ? "
                    + " where masv = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getFullName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhoneNumber());
            ps.setInt(4, ChangeGender(student.isGender()));
            ps.setString(5, student.getAddress());
            ps.setString(6, student.getPathImage());
            ps.setString(7, student.getMasv());
            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static int RemoveByPrepareStatement(String id) {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "delete from student where masv = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static int RemoveByPrepareStatement_Grade(String id) {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "delete from grade where masv_fk = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static int UpdateByPrepareStatement_Grade(Grades grade) {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "update GRADE set english = ? , tinhoc = ?,"
                    + " gdtc = ? "
                    + " where masv_fk = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, grade.getEnglist());
            ps.setFloat(2, grade.getTinHoc());
            ps.setFloat(3, grade.getGDTC());
            ps.setString(4, grade.getId());

            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static int insert_Grade(Grades grade) throws SQLServerException {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "insert into Grade (MASV_FK , ENGLISH , TINHOC , GDTC) values (? , ? , ? ,?) ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(2, grade.getEnglist());
            ps.setFloat(3, grade.getTinHoc());
            ps.setFloat(4, grade.getGDTC());
            ps.setString(1, grade.getId());
            return ps.executeUpdate();
        } catch (SQLServerException ex) {
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static void FindByPrepareStatement(DefaultTableModel tableModel, String str) {
        SQLServerDataSource dataSource = configDataSource();
        try ( Connection conn = dataSource.getConnection()) {
            String sql = "Select * from student where masv like ? + '%' ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, str);
            ResultSet result = ps.executeQuery();
            tableModel.setRowCount(0);
            while (result.next()) {
                String id = result.getString(1);
                String fullName = result.getString(2);
                String email = result.getString(3);
                String phoneNumber = result.getString(4);
                String gender = result.getString(5);
                String address = result.getString(6);
                String pathImage = result.getString(7);
                tableModel.addRow(new Object[]{
                    id, fullName, email, phoneNumber, gender, address, pathImage
                });
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDataBaseStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static int ChangeGender(boolean gender) {
        if (gender) {
            return 1;
        }
        return 0;
    }

    private static Object getGender(int gender) {
        if (gender == 1) {
            return "Nam";
        }
        return "Nữ";
    }
    static NumberFormat formatterwithcomma = new DecimalFormat("##,###,##0.00");

    private static String caculator(String english, String tinhoc, String gdtc) {
        if (english != null && tinhoc != null && gdtc != null) {
            return formatterwithcomma.format((Float.valueOf(english) + Float.valueOf(tinhoc) + Float.valueOf(gdtc)) / 3);
        }
        return null;
    }

}
