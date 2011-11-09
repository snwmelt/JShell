/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

public class jshell
{
    private static String currentDir = "~";
    private static String promptPrefix = user.getUsername() + ": " + "~";
    private static String command = "";
    private static String argumentOne = "";
    //private static String argumentTwo = "";
    
    public static void main () {
        while (!(command.equals("logout"))) {
            System.out.print(promptPrefix + " ");
            command = main.keyboardOne.next();
            argumentOne = main.keyboardOne.nextLine();
            //argumentTwo = main.keyboardOne.nextLine();
            exec.main(command, argumentOne/*, argumentTwo*/);
        }    
    }
}
