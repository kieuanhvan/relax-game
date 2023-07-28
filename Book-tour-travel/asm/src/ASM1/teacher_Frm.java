package ASM1;

import ManagerDataBase.ManagerDataBaseStudent;
import ManagerMenu.dataProcessingTeacher_form;
import Objects.Grades;
import Objects.Student;
import Objects.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieu anh văn
 */
public class teacher_Frm extends javax.swing.JFrame {

    private JButton[] btns;
    private DefaultTableModel tableModel;
    public int indexSelected;
    dataProcessingTeacher_form teacher_form;
    public String actionState;
    private User user;
    public ArrayList<Student> listStudents;
    public ArrayList<Grades> listGrades;

    public teacher_Frm() {

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            initComponents();
            setLocationRelativeTo(null);
            settingTableModel();
            addActionListeners();
            listStudents = new ArrayList<>();
            listGrades = new ArrayList<>();
            loadDataFromBaseToTable();
            ComboStart();
            addLabelToEvent();
            addTableToEvent();
            teacher_form = new dataProcessingTeacher_form(this);
            settingLabelFind();
            this.setVisible(true);
    

    }

    public teacher_Frm(User user) {
        this();
        this.user = user;
        this.setTitle("Tài Khoảng: " + user.getFullName().toUpperCase());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtMasv = new javax.swing.JTextField();
        txtEnglish = new javax.swing.JTextField();
        txtTin = new javax.swing.JTextField();
        txtBGD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        labelTongDiem = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpgrade = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listStudent = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        labelTop = new javax.swing.JTextField();
        btnFindStudentVip = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        btnShowListStudentGrade = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lí Điểm Sinh Viên");

        jPanel2.setBackground(new java.awt.Color(236, 236, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Mã Sinh Viên:");

        txtFind.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(""), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-find-35.png"))); // NOI18N
        btnSearch.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFind)
                .addGap(28, 28, 28)
                .addComponent(btnSearch)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel3.setBackground(new java.awt.Color(236, 236, 236));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nhập Liệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Họ & Tên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Mã Sinh Viên:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tiếng Anh:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tin Học:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Giáo Dục TC:");

        txtFullName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtFullName.setForeground(new java.awt.Color(51, 0, 255));

        txtMasv.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMasv.setForeground(new java.awt.Color(51, 0, 255));

        txtEnglish.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtTin.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        txtBGD.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Điểm TB");

        labelTongDiem.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelTongDiem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelTongDiem.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBGD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTongDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMasv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBGD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTongDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        jPanel4.setBackground(new java.awt.Color(236, 236, 236));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(0, 0, 204))); // NOI18N

        btnNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-50.png"))); // NOI18N
        btnNew.setText("New");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-save-50.png"))); // NOI18N
        btnSave.setText("Save");

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-50.png"))); // NOI18N
        btnDelete.setText("Delete");

        btnUpgrade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpgrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-upgrade-50.png"))); // NOI18N
        btnUpgrade.setText("Upgrade");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpgrade, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnUpgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(236, 236, 236));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));

        listStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        listStudent.setFocusable(false);
        listStudent.setSelectionBackground(new java.awt.Color(153, 255, 153));
        jScrollPane1.setViewportView(listStudent);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 153));
        jLabel10.setText("Hiển Thị Top :");

        btnFindStudentVip.setText("Find");
        btnFindStudentVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindStudentVipActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 153));
        jLabel11.setText("Xuất Sắc");

        labelStatus.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(0, 0, 255));
        labelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnShowListStudentGrade.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnShowListStudentGrade.setText("Hiển Thị Toàn Bộ Danh Sách");
        btnShowListStudentGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowListStudentGradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnShowListStudentGrade)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTop, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnFindStudentVip))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(btnFindStudentVip))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTop, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnShowListStudentGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chevron-right-504.png"))); // NOI18N

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-double-left-50.png"))); // NOI18N

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chevron-left-50.png"))); // NOI18N

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-double-right-50.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindStudentVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindStudentVipActionPerformed
        showTopStudentExcellent();
    }//GEN-LAST:event_btnFindStudentVipActionPerformed

    private void btnShowListStudentGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowListStudentGradeActionPerformed
        txtFind.setText(null);
        showAllListGrade();
        actionState = null;
    }//GEN-LAST:event_btnShowListStudentGradeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFindStudentVip;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowListStudentGrade;
    private javax.swing.JButton btnUpgrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JTextField labelTongDiem;
    private javax.swing.JTextField labelTop;
    private javax.swing.JTable listStudent;
    private javax.swing.JTextField txtBGD;
    private javax.swing.JTextField txtEnglish;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtMasv;
    private javax.swing.JTextField txtTin;
    // End of variables declaration//GEN-END:variables

    private void loadDataFromBaseToTableStudentGotScore() {
        ManagerDataBaseStudent.loadDataGrade_WhenStudentGotGrade(tableModel);
    }

    private void loadDataFromBaseToTableStudentNoScore() {
        ManagerDataBaseStudent.loadDataGrade_WhenStudentNotGrade(tableModel);
    }

    private void addActionListeners() {
        btns = new JButton[]{
            btnSave, btnDelete, btnUpgrade, btnNew, btnBack, btnNext, btnFirst, btnLast
        };
        for (JButton btn : btns) {
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();

                    if (button.equals(btnSave)) {
                        actionState = "save";
                        teacher_form.SaveForm();
                    }
                    if (button.equals(btnDelete)) {
                        actionState = "delete";
                        if (indexSelected != -1) {
                            teacher_form.DeleteStudent(indexSelected, (String) tableModel.getValueAt(indexSelected, 0));
                        } else {
                            ShowMessage("chọn dòng vị trí trong bảngđể xóa sinh viên");
                        }

                    }
                    if (button.equals(btnUpgrade)) {
                        String action = null;
                        if (actionState == "findData") {
                            action = "findData";
                        }
                        actionState = "updade";
                        teacher_form.UpdateStudent(indexSelected);
                        if (action != null) {
                            showTopStudentExcellent();
                        }
                    }
                    if (button.equals(btnNew)) {
                        teacher_form.newForm();
                        txtFind.setText(null);
                        labelTop.setText(null);
                        labelStatus.setText(null);
                        loadDataFromBaseToTable();
                        actionState = null;
                    }
                    if (button.equals(btnFirst)) {
                        ComboStart();
                    }
                    if (button.equals(btnLast)) {
                        indexSelected = listStudent.getRowCount() - 1;
                        showClick();
                        showDataToTextBox();
                    }
                    if (button.equals(btnBack)) {
                        indexSelected--;
                        if (indexSelected < 0) {
                            indexSelected = listStudent.getRowCount() - 1;
                        }
                        showClick();
                        showDataToTextBox();
                    }
                    if (button.equals(btnNext)) {
                        indexSelected++;
                        if (indexSelected == listStudent.getRowCount()) {
                            indexSelected = 0;
                            showClick();
                            showDataToTextBox();
                        }
                        showClick();
                        showDataToTextBox();
                    }
                }
            });
        }
    }

    public void ShowMessage(String str) {
        JOptionPane.showMessageDialog(rootPane, str);
    }

    private void settingTableModel() {
        tableModel = (DefaultTableModel) listStudent.getModel();
        tableModel.setColumnIdentifiers(new Object[]{
            "Mã SV", "Họ&Tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB"
        });
    }

    /*method*/
    private void loadDataFromBaseToTable() {
        ManagerDataBaseStudent.loadData(null, listStudents);
        ManagerDataBaseStudent.loadDataGrade(tableModel, listGrades);
    }

    public void ComboStart() {
        indexSelected = 0;
        showClick();
        showDataToTextBox();
    }

    /*getter / setter*/
    public void showClick() {
        try {
            listStudent.setRowSelectionInterval(indexSelected, indexSelected);
        } catch (Exception e) {
            ShowMessage("hiện tại danh sách đang trống");
            indexSelected = -1;
            return;
        }
    }

    public void showDataToTextBox() {
        try {
            txtMasv.setText((String) tableModel.getValueAt(indexSelected, 0));
            txtFullName.setText((String) tableModel.getValueAt(indexSelected, 1));
            txtEnglish.setText((String) tableModel.getValueAt(indexSelected, 2));
            txtTin.setText((String) tableModel.getValueAt(indexSelected, 3));
            txtBGD.setText((String) tableModel.getValueAt(indexSelected, 4));
            labelTongDiem.setText((String) tableModel.getValueAt(indexSelected, 5));

        } catch (Exception ex) {
            return;
        }

    }

    NumberFormat formatterwithcomma = new DecimalFormat("##,###,##0.00");

    private void addLabelToListenDocument(JTextField label) {
        label.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                checkGrade();
            }

            public void removeUpdate(DocumentEvent e) {
                checkGrade();
            }

            public void insertUpdate(DocumentEvent e) {
                checkGrade();
            }
        });
    }

    public void checkGrade() {
        if (!txtEnglish.getText().isEmpty() && !txtTin.getText().isEmpty()
                && !txtBGD.getText().isEmpty()) {
            try {
                labelTongDiem.setText(formatterwithcomma.format((Float.valueOf(txtEnglish.getText())
                        + Float.valueOf(txtTin.getText())
                        + Float.valueOf(txtBGD.getText())) / 3
                ));
            } catch (Exception e) {
                ShowMessage("Tất cả các ô nhập điểm phải là con số");
                return;
            }
            checkValidGrade();
        } else {
            labelTongDiem.setText(null);
        }

    }

    private void checkValidGrade() {
        int min = 0, max = 10;
        if (Float.valueOf(txtEnglish.getText()) < min || Float.valueOf(txtEnglish.getText()) > max) {
            ShowMessage("Điểm tiếng anh phải [0..10]");
            labelTongDiem.setText("!!!");
            return;
        }

        if (Float.valueOf(txtTin.getText()) < min || Float.valueOf(txtTin.getText()) > max) {
            ShowMessage("Điểm Tin anh phải [0..10]");
            labelTongDiem.setText("!!!");
            return;
        }

        if (Float.valueOf(txtBGD.getText()) < min || Float.valueOf(txtBGD.getText()) > max) {
            ShowMessage("Điểm GDTC anh phải [0..10]");
            labelTongDiem.setText("!!!");
            return;
        }
    }

    private void addLabelMouseListener(JTextField label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setEditable(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setEditable(true);
            }
        });
    }

    private void addLabelToEvent() {
        addLabelToListenDocument(txtEnglish);
        addLabelToListenDocument(txtTin);
        addLabelToListenDocument(txtBGD);
        addJtextFieldMasvToDocument();
        addLabelMouseListener(txtFullName);
    }

    private void addTableToEvent() {
        listStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                indexSelected = listStudent.getSelectedRow();
                showDataToTextBox();
                showClick();
            }
        });
    }

    /*getter setter*/
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JTextField getLabelEnglish() {
        return txtEnglish;
    }

    public void setLabelEnglish(JTextField labelEnglish) {
        this.txtEnglish = labelEnglish;
    }

    public JTextField getLabelFullName() {
        return txtFullName;
    }

    public void setLabelFullName(JTextField labelFullName) {
        this.txtFullName = labelFullName;
    }

    public JTextField getLabelGDTC() {
        return txtBGD;
    }

    public void setLabelGDTC(JTextField labelGDTC) {
        this.txtBGD = labelGDTC;
    }

    public JTextField getLabelMASV() {
        return txtMasv;
    }

    public void setLabelMASV(JTextField labelMASV) {
        this.txtMasv = labelMASV;
    }

    public JTextField getLabelTin() {
        return txtTin;
    }

    public void setLabelTin(JTextField labelTin) {
        this.txtTin = labelTin;
    }

    public JTextField getLabelTongDiem() {
        return labelTongDiem;
    }

    public void setLabelTongDiem(JTextField labelTongDiem) {
        this.labelTongDiem = labelTongDiem;
    }

    public JTextField getLalbelGetMASV() {
        return txtFind;
    }

    public void setLalbelGetMASV(JTextField lalbelGetMASV) {
        this.txtFind = lalbelGetMASV;
    }

    public JTable getListStudent() {
        return listStudent;
    }

    public void setListStudent(JTable listStudent) {
        this.listStudent = listStudent;
    }

    private void settingLabelFind() {
        txtFind.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                findStudent();
            }

            public void removeUpdate(DocumentEvent e) {
                findStudent();
            }

            public void insertUpdate(DocumentEvent e) {
                findStudent();
            }
        });
    }

    public void findStudent() {

        String idStudent = txtFind.getText().trim();
        tableModel.setRowCount(0);
        indexSelected = -1;
        listStudent.clearSelection();
        teacher_form.newForm();
        labelStatus.setText(null);
        for (int i = 0; i < listGrades.size(); i++) {
            if (listGrades.get(i).getId().matches(idStudent + "[a-zA-Z0-9\\s+ \\p{L}]+")
                    || listGrades.get(i).getId().compareTo(idStudent) == 0) {
                showStudentGrade(i);
                ComboStart();
            }
        }
    }

    private void addComboBoxToListener(JComboBox<String> comboBox) {
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                labelTop.setText(null);
                txtFind.setText(null);
            }
        });
    }

    private void addJtextFieldMasvToDocument() {
        txtMasv.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if (actionState != "delete") {
                    findnameStudent();
                }

            }

            public void removeUpdate(DocumentEvent e) {
                if (actionState != "delete") {
                    findnameStudent();
                }
            }

            public void insertUpdate(DocumentEvent e) {
                if (actionState != "delete") {
                    findnameStudent();
                }
            }

            private void findnameStudent() {
                if (txtMasv.getText().isEmpty()) {
                    txtFullName.setText(null);
                    return;
                }
                for (Student item : listStudents) {
                    if (txtMasv.getText().equalsIgnoreCase(item.getMasv())) {
                        txtFullName.setText(item.getFullName());
                        break;
                    } else {
                        txtFullName.setText("Sinh viên Chưa Tồn Tại");
                    }
                }

                for (Grades item : listGrades) {
                    if (item.getId().toLowerCase().equalsIgnoreCase(txtMasv.getText().toLowerCase())) {
                        txtEnglish.setText(String.valueOf(item.getEnglist()));
                        txtBGD.setText(String.valueOf(item.getGDTC()));
                        txtTin.setText(String.valueOf(item.getTinHoc()));
                        for (int i = 0; i < tableModel.getRowCount(); i++) {
                            if (tableModel.getValueAt(i, 0).toString().equalsIgnoreCase(txtMasv.getText())) {
                                indexSelected = i;
                                showClick();
                                break;
                            }
                        }
                        break;
                    } else {
                        txtEnglish.setText(null);
                        txtBGD.setText(null);
                        txtTin.setText(null);
                        labelTongDiem.setText(null);
                        indexSelected = -1;
                        listStudent.clearSelection();
                    }
                }
            }
        });
    }

    private void showStudentGrade(int i) {
        tableModel.addRow(new Object[]{
            listGrades.get(i).getId(), listGrades.get(i).getName(), listGrades.get(i).getEnglist(),
            listGrades.get(i).getTinHoc(), listGrades.get(i).getGDTC(),
            teacher_form.caculator(listGrades.get(i).getEnglist(),
            listGrades.get(i).getTinHoc(), listGrades.get(i).getGDTC())
        });

    }

    private void showAllListGrade() {
        labelTop.setText(null);
        ManagerDataBaseStudent.loadDataGrade(tableModel, listGrades);
        labelStatus.setText(null);
        ComboStart();
    }

    private void showTopStudentExcellent() {
        actionState = "findData";
        txtFind.setText(null);
        try {
            float number = Float.valueOf(labelTop.getText());
            int num = (int) number;
            if (num > listGrades.size()) {
                ShowMessage("Thất bại vì số lượng top sinh viên hiển thị > số lượng sinh viên thực tế trong bảng!!!");
            } else {
                ManagerDataBaseStudent.loadDataGrade_WithTop(tableModel, num);
                ComboStart();
            }
        } catch (Exception e) {
            ShowMessage("Bạn cần nhập vào ô tìm kiếm là một con số   hoặc số > 0");
        }
        txtFind.setText(null);
        labelStatus.setText("Top " + ((labelTop.getText() == null) ? 0 : labelTop.getText()) + " Sinh viên xuất sắc");
    }

}
