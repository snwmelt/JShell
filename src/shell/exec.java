/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

public class exec
{
    public static void main (String command) {
        Class a = command.getClass();
        System.out.println(a);

    }

    public static void echo (String echoThis) {
        System.out.print(echoThis);
        System.out.println();
    }
        
    public static void quit () {
        System.out.println("\nGoodbye!");
        System.exit(0);
    }
}