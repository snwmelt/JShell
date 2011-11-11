/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;
import java.io.*;

public class read {
    public static void main (String argumentOne) {
        try {shell.io.printFile(argumentOne);
            }
        
        catch (IOException IOE) {
            System.out.println("I/O Error");
            }
    }    
}
