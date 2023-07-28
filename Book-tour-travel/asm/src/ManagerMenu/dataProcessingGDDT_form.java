package ManagerMenu;

import ASM1.GDDT;
import ManagerDataBase.ManagerDataBaseStudent;
import Objects.Student;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieu anh văn
 */
public class dataProcessingGDDT_form implements ManagerFormGDDT {

    private GDDT formGddt;
    Component[] listComponents;

    public dataProcessingGDDT_form(GDDT gddt) {
        this.formGddt = gddt;
    }

    @Override
    public void newForm() {
        this.listComponents = formGddt.listComponents;
        clearForm(listComponents);
        formGddt.indexSelected = -1;
    }
    
      public void clearForm(Component[] listComponents) {
        for (Component item : listComponents) {
            if (item instanceof JTextField) {
                JTextField t = (JTextField) item;
                t.setText(null);
                continue;
            }
            formGddt.getBg().clearSelection();
            if (item instanceof JScrollPane) {
                JTextArea t = (JTextArea) ((JScrollPane) item).getViewport().getComponent(0);
                t.setText(null);
            }
        }
        formGddt.getTableList().clearSelection();
        formGddt.deFaultImagePath();
        formGddt.loadIcon(formGddt.pathImage);
    }

    @Override
    public void SaveForm(Student student, DefaultTableModel model) {
        String check = CheckInput(student);
        if (check == null) {
            try {
                int index = ManagerDataBaseStudent.insertDataByPrepareStatement(student);
                if (index > 0) {
                    model.addRow(new Object[]{
                        student.getMasv(), student.getFullName(), student.getEmail(), student.getPhoneNumber(),
                        student.isGender() ? "Nam":"Nữ", student.getAddress(), student.getPathImage()
                    });
                    afterNewbtn();
                    formGddt.getTableList().scrollRectToVisible(formGddt.getTableList().
                            getCellRect(formGddt.getTableList().getRowCount() - 1, 0, true));
                }
            } catch (Exception ex) {
                showmessage("Mã sinh viên đã tồn tại");
            }
        } else {
            showmessage(check);
        }
    }

    public void showmessage(String str) {
        JOptionPane.showConfirmDialog(formGddt, str);
    }

    @Override
    public void DeleteStudent(int index, String id) {
        int result = ManagerDataBaseStudent.RemoveByPrepareStatement(id);
        if (result > 0) {
            formGddt.tableModel.removeRow(index);
            showmessage("Xóa Thành công");

            if (formGddt.tableModel.getRowCount() < 0) {
                newForm();
                return;
            }

            if (formGddt.indexSelected == 0) {
                formGddt.indexSelected = 0;
                formGddt.showClicked();
                formGddt.showDataToTextBox();
                return;
            }
            if (formGddt.indexSelected == formGddt.tableModel.getRowCount()) {
                formGddt.indexSelected = formGddt.tableModel.getRowCount() - 1;
                formGddt.showClicked();
                formGddt.showDataToTextBox();
                return;
            }
            formGddt.showClicked();
            formGddt.showDataToTextBox();
        }
    }

    @Override
    public void UpdateStudent(int index, Student student) {
        String check = CheckInput(student);
        if (check == null) {
            if (!isExistStudent(student)) {
                showmessage("Hiện tại chưa có sinh viên này nên không thể update ");
                return;
            }
            if (student.getMasv().compareTo(formGddt.tableModel.getValueAt(index, 0).toString()) != 0) {
                showmessage("Không được thay đổi mã sinh viên");
                return;
            }
            if (formGddt.indexSelected == -1) {
                showmessage("vui lòng chọn vào sinh viên Update");
            } else {
                int result = ManagerDataBaseStudent.UpdateByPrepareStatement(student);
                if (result > 0) {
                    formGddt.tableModel.setValueAt(student.getFullName(), index, 1);
                    formGddt.tableModel.setValueAt(student.getEmail(), index, 2);
                    formGddt.tableModel.setValueAt(student.getPhoneNumber(), index, 3);
                    formGddt.tableModel.setValueAt(getGender(student.isGender()), index, 4);
                    formGddt.tableModel.setValueAt(student.getAddress(), index, 5);
                    formGddt.tableModel.setValueAt(student.getPathImage(), index, 6);
                    showmessage("Update thành công");
                } else {
                    showmessage("Thất bại");
                }
            }
        } else {
            showmessage(check);
        }
    }

    private Object getGender(boolean gender) {
        if (gender) {
            return "Nam";
        }
        return "Nữ";
    }

    private String CheckInput(Student student) {
        if (student.getMasv().isEmpty()) {
            return "Không để trống mã SV";
        }
        if (student.getFullName().isEmpty()) {
            return "Không để trống tên";
        }
        if (student.getEmail().isEmpty()) {
            return "Không để trống email";
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+[\\\\w._]*@gmail.com$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(student.getEmail());
        if (!matcher.matches()) {
            return "Định dạng gmail không chính xác\nVí dụ : abc@gmail.com";
        }
        if (student.getPhoneNumber().isEmpty()) {
            return "Không để trống số điện thoại";
        }
        Pattern pattern1 = Pattern.compile("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$", Pattern.CASE_INSENSITIVE);
        
        Matcher matcher1 = pattern1.matcher(student.getPhoneNumber());
        if (!matcher1.matches()) {
            return "Định dạng điện thoại không chính xác\nVí dụ : 0347179458";
        }
        if (!formGddt.getRdoNam().isSelected() && !formGddt.getRdoNu().isSelected()) {
            return "Chọn Giới tính cho sinh viên";
        }
        if (student.getAddress().isEmpty()) {
            return "Không để trống địa chỉ học sinh";
        }

        if (student.getPathImage().compareTo("icons8-plus-100.png") == 0) {
            return "Vui lòng chọn ảnh cho sinh viên";
        }

        return null;
    }

    public void afterNewbtn() {
        formGddt.indexSelected = formGddt.tableModel.getRowCount() - 1;
        formGddt.showDataToTextBox();
        formGddt.showClicked();

    }

  

    private boolean isExistStudent(Student student) {
        for (int i = 0; i < formGddt.tableModel.getRowCount(); i++) {
            if (student.getMasv().compareTo(formGddt.tableModel.getValueAt(i, 0).toString()) == 0) {
                return true;
            }
        }
        return false;
    }
}
