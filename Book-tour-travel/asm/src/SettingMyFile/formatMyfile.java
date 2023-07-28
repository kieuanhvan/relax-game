
package SettingMyFile;

import java.io.File;

/**
 *
 * @author kieu anh văn
 */
public class formatMyfile {
    public static  final  String XLSX = ".xlsx";
    
    public static String getExtensionFile(File file){
        String ex = null;
        String fileName = file.getName();
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex > 0 )  {
            return ex.substring(lastDotIndex);
        }
        return ex;
    }
}
