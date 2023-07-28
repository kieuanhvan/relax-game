package GameCaro;

import GameCaro.Manager_chess_imp;
import MenuGame.menuHome;
import Streamer.PlayerSnake;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kieu anh văn
 */
public class CaroFrm extends javax.swing.JFrame {

    private Manager_chess_imp manager;
    public boolean isdelay;
    public boolean IsEnabled;
    public PlayerSnake playerGame;
    private menuHome homeGame;
    public CaroFrm() {
        initComponents();
        CaroFrm.this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent event){
                manager.WriteDataToFile();
            }
        });
        this.IsEnabled= false;
        isdelay = false;
       
        setLocationRelativeTo(null);
        CaroFrm.this.addWindowListener(new WindowAdapter(){
            public void WindowClosing(WindowEvent event) {
                
            }
        });
//        AllTimePlaygame time = AllTimePlaygame();
    }
    public CaroFrm(PlayerSnake playerGame , menuHome homeGame){
        this();
        this.homeGame = homeGame;
        this.playerGame = playerGame;
         manager = new Manager_chess_imp(this);
        manager.drawTableChess();
        manager.timePlayer(pnlIcon);
        label_ID.setText("ID BÀN CỜ : " +this.playerGame.getFullName() + "_CHESS_TEAM_5");
    }
    public JLabel getTxtPlayer1() {
        return txtPlayer1;
    }

    public JLabel getLabelTime() {
        return labelTime;
    }

    public void setLabelTime(JLabel labelTime) {
        this.labelTime = labelTime;
    }
    
    public void setTxtPlayer1(JLabel txtPlayer1) {
        this.txtPlayer1 = txtPlayer1;
    }

    public JLabel getTxtPlayer2() {
        return txtPlayer2;
    }

    public void setTxtPlayer2(JLabel txtPlayer2) {
        this.txtPlayer2 = txtPlayer2;
    }

    public JLabel getLabelImge() {
        return labelImge;
    }

    public void setLabelImge(JLabel labelImge) {
        this.labelImge = labelImge;
    }

    public JLabel getLabel_point() {
        return label_point;
    }

    public void setLabel_point(JLabel label_point) {
        this.label_point = label_point;
    }

    public JPanel getPnlCaro() {
        return pnlCaro;
    }

    public void setPnlCaro(JPanel pnlCaro) {
        this.pnlCaro = pnlCaro;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCaro = new javax.swing.JPanel();
        pnlIcon = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        labelImge = new javax.swing.JLabel();
        txtPlayer1 = new javax.swing.JLabel();
        txtPlayer2 = new javax.swing.JLabel();
        label_point = new javax.swing.JLabel();
        tbnChangeName = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        label_ID = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlCaro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlCaroLayout = new javax.swing.GroupLayout(pnlCaro);
        pnlCaro.setLayout(pnlCaroLayout);
        pnlCaroLayout.setHorizontalGroup(
            pnlCaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        pnlCaroLayout.setVerticalGroup(
            pnlCaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        pnlIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carro_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlIconLayout = new javax.swing.GroupLayout(pnlIcon);
        pnlIcon.setLayout(pnlIconLayout);
        pnlIconLayout.setHorizontalGroup(
            pnlIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIconLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        pnlIconLayout.setVerticalGroup(
            pnlIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIconLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jPanel3.setBackground(new java.awt.Color(242, 231, 231));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        labelImge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPlayer1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtPlayer1.setText("Player1");

        txtPlayer2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtPlayer2.setText("Player2");

        label_point.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        label_point.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtPlayer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_point, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(txtPlayer2)
                .addGap(50, 50, 50))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelImge, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPlayer1)
                                    .addComponent(label_point)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtPlayer2)))
                        .addGap(28, 28, 28)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelImge, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tbnChangeName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tbnChangeName.setText("Change Name Player");
        tbnChangeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnChangeNameActionPerformed(evt);
            }
        });

        btnPause.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        label_ID.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        label_ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_ID.setText("Mã Bàn Cờ:");

        labelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTime.setText("time");

        jMenu1.setText("Account");

        jMenuItem1.setText("LogOut");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(label_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlCaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tbnChangeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(label_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbnChangeName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbnChangeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnChangeNameActionPerformed
        isdelay = true;
        ChangeNamePlayer changeName = new ChangeNamePlayer(this, rootPaneCheckingEnabled);
        manager.ChangeNamePlayers(changeName);
    }//GEN-LAST:event_tbnChangeNameActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        if (btnPause.getText().compareTo("Pause") == 0) {
            isdelay = true;
            manager.getIsdelay(isdelay);
            btnPause.setText("Continue");
            IsEnabled = true;
        } else {
            isdelay = false;
            manager.getIsdelay(isdelay);
            btnPause.setText("Pause");
            IsEnabled = false;
        }
    }//GEN-LAST:event_btnPauseActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
        this.homeGame.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaroFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPause;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelImge;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel label_ID;
    private javax.swing.JLabel label_point;
    private javax.swing.JPanel pnlCaro;
    private javax.swing.JPanel pnlIcon;
    private javax.swing.JButton tbnChangeName;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel txtPlayer1;
    private javax.swing.JLabel txtPlayer2;
    // End of variables declaration//GEN-END:variables


}
