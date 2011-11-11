/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

public class cd {
    //[Code] Pathing
    public static void main (String newDir) {
        if (shell.io.isPathRelative(newDir) == false) {
            shell.io.setCurrentDir(newDir);
        }
        
        else if (newDir.startsWith("..")) {
                shell.io.setCurrentDir(shell.io.getCurrentDir().getParent());
        }
        
        else if (newDir.startsWith("./")) {
                shell.io.setCurrentDir(shell.io.getNewDir(newDir).toString());
        }
        
        else {
                shell.io.setCurrentDir(shell.io.getNewDir(newDir).toString());
        }
    }    
}
