/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;
import java.io.*;

public class sysExec {
    public static void main (String command, String arg) {
        if (command.startsWith(".")) {
            command = command.replace("./", shell.io.getCurrentDir().toString());
            System.out.println("[Debug exec] command: " + command);
        }

        ProcessBuilder pb = new ProcessBuilder(command, arg);

        pb.directory(shell.io.getCurrentDir());
       
        try {
            Process p = pb.start();
        }
        catch (IOException IOE) {
            System.out.println("Failed to launch process (IOE)");
        }
    }    
}
