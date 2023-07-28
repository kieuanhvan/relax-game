
package ManagerMenu;

import Objects.Student;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieu anh văn
 */
public interface ManagerFormGDDT {
    void newForm( );
    void SaveForm(Student student,DefaultTableModel model);
    void DeleteStudent(int index , String id);
    void UpdateStudent(int index , Student student);
    
    
}
