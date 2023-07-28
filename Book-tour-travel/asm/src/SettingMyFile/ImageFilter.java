
package SettingMyFile;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author kieu anh văn
 */
public class ImageFilter extends  FileFilter{

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String namefile = formatMyfile.getExtensionFile(f).toLowerCase();
        if (namefile != null) {
            if (namefile.equals( formatMyfile.XLSX)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return ".xlsx";
    }
    
}
