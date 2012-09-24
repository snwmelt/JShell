/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;
import java.io.*;

public class path {
    private static File currentPath = new File (System.getProperty("user.dir"));
    private static File newPath = new File("");   
    
    public static File getCurrentPath() {
        return currentPath;
    }
       
    public static void setCurrentPath(String argumentOne) {
        currentPath = new File (argumentOne);
    }
    
    public static File getNewPath(String path) {
        newPath = new File (path);
        return newPath;
    }
    
    public static Boolean isPathRelative (String path) {
        Boolean isRelative = true;
        char[] dirArray = path.toCharArray();
        if ((shell.OSUtils.getOSType().equals("Unix") && dirArray[0] == shell.OSUtils.getAbsolutePathCharacter()) || (shell.OSUtils.getOSType().equals("Windows")
                && dirArray[1] == shell.OSUtils.getAbsolutePathCharacter())) {
            isRelative = false;
        }
         return isRelative;
    }
    
    public static String getAbsolutePath (String path) {
        String absolutePath = getCurrentPath() + path.replace("./", shell.OSUtils.getFileSeparator());
        return absolutePath;
    }

    public static File stripFileParent (File file) {
        String stripThis = file.toString();
        File strippedFile = new File(stripThis.replace(file.getParent(), ""));
        return strippedFile;
    }    
}
