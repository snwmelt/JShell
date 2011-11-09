/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

public class OSUtils
{
    private static String OS = System.getProperty("os.name");
    private static String arch = System.getProperty("os.arch");
    private static String fileSeparator = System.getProperty("file.separator");
    
    public static String getOS () {
        return OS;
    }
    
    public static String getArch () {
        return arch;
    }
    
    public static String getFileSeparator () {
        return fileSeparator;
    }
}
