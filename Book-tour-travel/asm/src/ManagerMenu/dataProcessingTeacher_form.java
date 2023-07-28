package ManagerMenu;

import ASM1.teacher_Frm;
import ManagerDataBase.ManagerDataBaseStudent;
import Objects.Grades;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kieu anh văn
 */
public class dataProcessingTeacher_form implements ManagerFormTeacher {
    
    private teacher_Frm teachFrm;
    
    public dataProcessingTeacher_form(teacher_Frm teachFrm) {
        this.teachFrm = teachFrm;
    }
    
    @Override
    public void newForm() {
        teachFrm.getLabelEnglish().setText(null);
        teachFrm.getLabelTin().setText(null);
        teachFrm.getLabelGDTC().setText(null);
        teachFrm.getLabelMASV().setText(null);
        teachFrm.getLabelFullName().setText(null);
        teachFrm.indexSelected = -1;
        teachFrm.getListStudent().clearSelection();
    }
    
    @Override
    public void SaveForm() {
        String masv = teachFrm.getLabelMASV().getText();
        String fullname = teachFrm.getLabelFullName().getText();
        float english = getNumber(teachFrm.getLabelEnglish().getText());
        float tinhoc = getNumber(teachFrm.getLabelTin().getText());
        float gdtc = getNumber(teachFrm.getLabelGDTC().getText());
        String check = checkInput(english, tinhoc, gdtc);
        if (check == null) {
            Grades grade = new Grades(masv, fullname, english, tinhoc, gdtc);
            
            if (teachFrm.actionState.compareTo("save") == 0) {
                if (!teachFrm.listGrades.contains(grade)) {
                    try {
                        int result = ManagerDataBaseStudent.insert_Grade(grade);
                        if (result > 0) {
                            showDataToTable(grade);
                            teachFrm.listGrades.add(grade);
                            showmessage("Lưu  thành công");
                            teachFrm.indexSelected = teachFrm.getTableModel().getRowCount() - 1;
                            teachFrm.showClick();
                            teachFrm.getListStudent().scrollRectToVisible(teachFrm.getListStudent().
                                    getCellRect(teachFrm.getListStudent().getRowCount() - 1, 0, true));
                        }
                    } catch (SQLServerException ex) {
                        showmessage("Mã sinh viên không hợp lệ , kiểm tra lại  ");
                    }
                } else {
                    showmessage("ID đã tồn tại");
                }
            } else {
                int result = ManagerDataBaseStudent.UpdateByPrepareStatement_Grade(grade);
                if (result > 0) {
                    
                    int indexGrades = getIndex(grade.getId());
                    teachFrm.listGrades.set(indexGrades, grade);
                    showmessage("update thanh công ");
                    try {
                        Update_DataToTableMode(grade);
                    } catch (Exception e) {
                        System.out.println("update thanh cong");
                    }
                    
                }
                if (result == 0) {
                    showmessage("Hiện tại sinh viên này chưa có trong danh sách nên không thể update");
                }
            }
        } else {
            showmessage(check);
        }
    }
    
    @Override
    public void DeleteStudent(int index, String id) {
            int result = ManagerDataBaseStudent.RemoveByPrepareStatement_Grade(id);
            if (result > 0) {
                teachFrm.getTableModel().removeRow(index);
                teachFrm.listGrades.remove(index);
                
                teachFrm.getTableModel().fireTableDataChanged();
                showmessage("Xóa Sinh viên thành công");
                afterDelete();
            } else {
                showmessage("Xóa sinh viên thất bại");
            }
       
    }
    
    @Override
    public void UpdateStudent(int index) {
       
        SaveForm();
    }
    
    private String checkInput(float english, float tinhoc, float gdtc) {
        if (english == -1 || tinhoc == -1 || gdtc == -1) {
            return "Thất Bại ! Phải đảm bảo điểm là số";
        }
        
        if (english > 10 || english < 0 || tinhoc > 10 || tinhoc < 0 || gdtc > 10 || gdtc < 0) {
            return "Thất bại ! Điểm phải trong khoảng [0...10]";
        }
        
        return null;
        
    }
    
    private float getNumber(String text) {
        try {
            float num = Float.valueOf(text);
            return num;
        } catch (Exception e) {
            return -1;
        }
    }
    
    private void showmessage(String str) {
        JOptionPane.showMessageDialog(teachFrm, str);
    }
    
    private void Update_DataToTableMode(Grades grade) {
        teachFrm.getTableModel().setValueAt(String.valueOf(grade.getEnglist()), teachFrm.indexSelected, 2);
        teachFrm.getTableModel().setValueAt(String.valueOf(grade.getTinHoc()), teachFrm.indexSelected, 3);
        teachFrm.getTableModel().setValueAt(String.valueOf(grade.getGDTC()), teachFrm.indexSelected, 4);
        teachFrm.getTableModel().setValueAt(teachFrm.getLabelTongDiem().getText(), teachFrm.indexSelected, 5);
    }
     NumberFormat formatterwithcomma = new DecimalFormat("##,###,##0.00");

    public  String caculator(float english, float tinhoc, float gdtc) {
            return formatterwithcomma.format((Float.valueOf(english) + Float.valueOf(tinhoc) + Float.valueOf(gdtc)) / 3);
    }
    private void showDataToTable(Grades grade) {
        teachFrm.getTableModel().addRow(new Object[]{
            grade.getId() , grade.getName() ,grade.getEnglist() ,grade.getTinHoc() ,grade.getGDTC(),
            caculator(grade.getEnglist() ,grade.getTinHoc() ,grade.getGDTC())
        });
    }
    
    private int getIndex(String id) {
        for (int i = 0; i < teachFrm.listGrades.size(); i++) {
            if (id.compareTo(teachFrm.listGrades.get(i).getId()) == 0) {
                return i;
            }
        }
        return -1;
    }

    private void afterDelete() {
        if (teachFrm.getTableModel().getRowCount() == 0) {
            newForm();
            return;
        }
        if (teachFrm.indexSelected  == teachFrm.getTableModel().getRowCount() ) {
            teachFrm.indexSelected = teachFrm.getTableModel().getRowCount() -1;
             System.out.println(teachFrm.indexSelected);
        }
        teachFrm.showClick();
        teachFrm.showDataToTextBox();
        teachFrm.actionState = "update";
    }
    
}
