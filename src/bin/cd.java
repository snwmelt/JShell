/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

public class cd {
    //[Code] Pathing
    public static void main (String newDir) {
        if (shell.io.isPathRelative(newDir) == false) {
            try {
                shell.io.setCurrentDir(newDir);
            }
            catch (NullPointerException NPE) {
                     System.out.println("Null Pointer Exception. Are you sure that directory exists?");               
            }
        }
        
        else if (newDir.startsWith("..")) {
            try {
                shell.io.setCurrentDir(shell.io.getCurrentDir().getParent());
            }
            catch (NullPointerException NPE) {
                     System.out.println("Null Pointer Exception. Are you sure that directory exists?");               
            }
        }
        
        else if (newDir.startsWith("./")) {
            try {
                shell.io.setCurrentDir(shell.io.getNewDir(newDir).toString());
            }
            catch (NullPointerException NPE) {
                     System.out.println("Null Pointer Exception. Are you sure that directory exists?");               
            }            
        }
        
        else {
            try {
                shell.io.setCurrentDir(shell.io.getNewDir(newDir).toString());
            }
            catch (NullPointerException NPE) {
                     System.out.println("Null Pointer Exception. Are you sure that directory exists?");               
            }            
        }
    }    
}
