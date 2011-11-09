/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;
import java.io.*;

public class jshell
{
    private static String command = "";
    private static String argumentOne = "";
    //private static String argumentTwo = "";
    
    public static void main () {
        while (!(command.equals("logout"))) {
            System.out.print(getPromptPrefix());
            command = main.keyboardOne.next();
            String a1 = main.keyboardOne.nextLine();
            argumentOne = a1.trim();
            //argumentTwo = main.keyboardOne.nextLine();
            exec.main(command, argumentOne/*, argumentTwo*/);
        }
    }

    private static String getPromptPrefix() {
        String prompt = (user.getUsername() + ":" + " " + shell.io.getCurrentDir() + " ");
        return prompt;
    }
}