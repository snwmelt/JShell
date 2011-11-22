/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import java.io.*;

public class exec
{   
    public static void main (String command, String argumentOne, String argumentTwo, String argumentThree, String argumentFour) {
        //System.out.println("[Debug exec] exec() called");
        if (command.equals("cd")) {
            bin.cd.main(argumentOne);
        }
/*        else if (command.equals("changePassword")) {
            bin.changePassword.main(argumentOne);
        } */

        else if (command.equals("clear")) {
            bin.clear.main();
        }
        
        else if (command.equals("cmdList")) {
            bin.cmdList.main();
        }
        
        else if (command.equals("echo")) {
            bin.echo.main(argumentOne);
        }
                
        else if (command.equals("jgrep")) {
            bin.jgrep.main(argumentOne);
        }
        
        else if (command.equals("ls")) {
                try {
                    bin.ls.main (argumentOne, argumentTwo);
                }
                catch (IOException IOE) {
                    System.out.println("Could not list  directory contents. Do you have permission to view it?");
                }
                catch (NullPointerException NPE) {
                    System.out.println("Null Pointer Exception. Are you sure that directory exists?");
                }
        }
        
        else if (command.equals("quit")) {
            bin.quit.main();
        }
        
        else if (command.equals("read")) {
            bin.read.main(argumentOne);
        }
        
        else if (command.equals("su")) {
            bin.su.main(argumentOne);
        }
        
        else if (command.equals("sysInfo")) {
            bin.sysInfo.main();
        }
        
        else if (command.equals("sysExec")) {
            bin.sysExec.main(argumentOne,argumentTwo);
        }
        
        else {
            System.out.println("Unknown command, please try again. For a full list of commands try 'cmdList'.");
        }
    } 
}