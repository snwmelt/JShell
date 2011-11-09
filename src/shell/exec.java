/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import java.lang.reflect.*;

public class exec
{
    final static String ESC = "\033[";
    
    public static void main (String command, String argumentOne/*, String argumentTwo*/) {
       
        if (command.equals("clear")) {
            clear();
        }
        
        else if (command.equals("cmdList")) {
            cmdList();
        }
        
        else if (command.equals("echo")) {
            echo(argumentOne);
        }
                
        else if (command.equals("jgrep")) {
            jgrep(argumentOne);
        }
        
        else if (command.equals("quit")) {
            quit();
        }
        
        else if (command.equals("sysinfo")) {
            System.out.println("Operating System: " + OSUtils.getOS());
            System.out.println("Architecture: " + OSUtils.getArch());
            System.out.println("Java Version: " + System.getProperty("java.version"));
        }
        
        else {
            System.out.println("Unknown command, please try again. For a full list of commands please type 'cmdList'.");
        }
    }

    //[Workaround] Replace with proper solution
    public static void clear () {
        for (int i=0; i<25; ++i) System.out.println();
    }
    
    public static void cmdList () {
            Method list[] = exec.class.getDeclaredMethods();
            for (int i = 0; i < list.length; i++) {
                String unparsedList = (list[i].toString());
                String prefixParsedList = unparsedList.replace("public static void shell.exec.", "");
                String parsedList[] = prefixParsedList.split("\\(");
                System.out.println(parsedList[0]);
            }        
    }
    
    public static void echo (String echoThis) {
        System.out.print(echoThis);
        System.out.println();
    }

    //[FixMe] Really needs fixing
    public static void jgrep (String args) {
        String grep[] = args.split(" ");
        try {
            if (grep[0].matches(grep[1])) {
                System.out.println("The value does match the expresion.");
            }

            else {System.out.println("The given value does not match the supplied expression.");
            }
        }
        
        catch (java.lang.RuntimeException jlRE) {
            System.out.print("Error: " + jlRE);
        }

    }    
    
    public static void quit () {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}