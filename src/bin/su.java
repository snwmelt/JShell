/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

public class su {
    public static void main (String user) {
        
        if (user.isEmpty()) {
            shell.user.main("root");
        }
        
        else {
            shell.user.main(user);
        }
    }    
}
