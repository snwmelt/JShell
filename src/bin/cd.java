/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

public class cd {
    //[Code] Pathing
    public static void main (String newDir) {
        if (io.path.isPathRelative(newDir) == false) {
            io.path.setCurrentPath(newDir);
        }
        
        else if (newDir.startsWith("..")) {
                io.path.setCurrentPath(io.path.getCurrentPath().getParent());
        }
        
        else if (newDir.startsWith("./")) {
                io.path.setCurrentPath(io.path.getNewPath(newDir).toString());
        }
        
        else {
                io.path.setCurrentPath(io.path.getNewPath(newDir).toString());
        }
    }    
}
