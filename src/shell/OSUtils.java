/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;
import java.io.*;

public class OSUtils
{
    private static String OS = System.getProperty("os.name");
    private static String OSType = "";
    private static String arch = System.getProperty("os.arch");
    private static String fileSeparator = System.getProperty("file.separator");
    //private static char absolutePathCharacter = s
    
    public static String getOS () {
        return OS;
    }
    
    public static String getOSType() {
        if (OS.toLowerCase().contains("nux") || OS.toLowerCase().contains("nix") || OS.toLowerCase().contains("bsd")) {
            OSType = "Unix";
        }
        else if (OS.toLowerCase().contains("Windows")) {
            OSType = "Windows";
        }
        else if (OS.toLowerCase().contains("mac")) {
            OSType = "Mac";
        }
        return OSType;
    }
    
    public static String getArch () {
        return arch;
    }
    
    public static String getFileSeparator () {
        return fileSeparator;
    }
    
    public static char getAbsolutePathCharacter () {
        char APC = '/';
        if (getOSType().equals("nix")) {
            APC = '/';
        }
        else if (getOSType().equals("Windows")) {
            APC=':';
        }
        return APC;
    }
    
    public static String getRootName (File path) {
        String rootName = "";
        String pathString = path.toString();
        if (getOSType().equals("Windows")) {
            pathString.substring(0, 1);
        }
        else {
            rootName="/";
        }
        return rootName;
    }
}
