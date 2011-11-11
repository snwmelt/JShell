/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import java.lang.reflect.*;
import java.io.*;

public class exec
{   
    public static void main (String command, String argumentOne, String argumentTwo, String argumentThree, String argumentFour) {
        //System.out.println("[Debug exec] exec() called");
        if (command.equals("cd")) {
            cd(argumentOne);
        }
        else if (command.equals("changePassword")) {
            changePassword(argumentOne);
        }

        else if (command.equals("clear")) {
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
        
        else if (command.equals("ls")) {
                try {
                    ls (argumentOne, argumentTwo);
                }
                catch (IOException IOE) {
                    System.out.println("Could not list  directory contents. Do you have permission to view it?");
                }
                catch (NullPointerException NPE) {
                    System.out.println("Null Pointer Exception. Are you sure that directory exists?");
                }
        }
        
        else if (command.equals("quit")) {
            quit();
        }
        
        else if (command.equals("read")) {
            read(argumentOne);
        }
        
        else if (command.equals("su")) {
            su(argumentOne);
        }
        
        else if (command.equals("sysInfo")) {
            sysInfo();
        }
        
        else if (command.equals("sysExec")) {
            sysExec(argumentOne,argumentTwo);
        }
        
        else {
            System.out.println("Unknown command, please try again. For a full list of commands try 'cmdList'.");
        }
    }
    //[Code] Pathing
    public static void cd (String newDir) {
        if (io.isPathRelative(newDir) == false) {
            io.setCurrentDir(newDir);
        }
        else if (newDir.startsWith("..")) {
            io.setCurrentDir(io.getCurrentDir().getParent());
        }
        else if (newDir.startsWith("./")) {
            io.setCurrentDir(io.getNewDir(newDir).toString());
        }
    }
    
    public static void changePassword (String user) {
        System.out.print("Enter new password: ");
        String p1 = main.keyboardOne.nextLine();
        System.out.print("Confirm new password: ");
        String p2 = main.keyboardOne.nextLine();
        if (p1.equals(p2)) {
            if (user.isEmpty()) {
                shell.user.setPassword(shell.user.getUsername(), p1);
            }        
            else {
                shell.user.setPassword(user, p1);
            }
        }
        else {System.out.println("Passwords did not match, password not changed.");
        }
    }
    
    //[Code] Replace with proper solution
    public static void clear () {
        for (int i=0; i<70; ++i) System.out.println();
    }
    
    public static void cmdList () {
            Method list[] = exec.class.getDeclaredMethods();
            //i is set to 1 to avoid printing the inital array value as we do not want to include the main class in the output.
            for (int i = 1; i < list.length; i++) {
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

    public static void ls (String argumentOne, String argumentTwo) throws IOException, NullPointerException {
       //System.out.println("[Debug exec] Starting ls");
        File dir = null;
        Boolean hasParameter = true;
        if (argumentOne.isEmpty()) {
            argumentTwo = ".";
            hasParameter = false;
        }
        
        else if (argumentTwo.isEmpty()) {
            argumentTwo = argumentOne;
            hasParameter = false;
            //System.out.println("[Debug exec] Argument One is empty so Argument Two = Argument One");
            //System.out.println("[Debug exec] Has parameter = false");
        }
        
        if (io.isPathRelative(argumentTwo) == true) {
                        dir = shell.io.getCurrentDir();
        }

     else if (io.isPathRelative(argumentTwo) == false) {
          dir = shell.io.getNewDir(argumentTwo);
      }
        
        else {
            System.out.print("[Debug exec] None of these conditions were met");
        }

        File[] fileList = dir.listFiles();
        for (int i = 0;i < fileList.length; i++) {
            File file = fileList[i];
            if (hasParameter == true) {
                 if (argumentOne.equals("-A")) {
                     System.out.println("[Debug exec] hasParemeter = true");
                     try {
                         System.out.println(file);
                     }
                    catch (NullPointerException NPE) {
                        System.out.println("Null Pointer Exception. Something has gone terribly wrong here: ");
                        System.out.println(NPE);
                     }
                 }
                else {
                    System.out.println("Argument not recognised.");
                }
            }
            else if (io.isPathRelative(argumentTwo)) {
                try {
                    System.out.println("." + io.stripFileParent(file));
                }
                catch (NullPointerException NPE) {
                    System.out.println("Null Pointer Exception. Something has gone terribly wrong here: ");
                    System.out.println(NPE);
                }
            }
            else if (OSUtils.getRootName(file).equals(file.toString())) {
                try {
                    System.out.println(OSUtils.getRootName(file));
                }
                catch (NullPointerException NPE) {
                    System.out.println("Null Pointer Exception. Something has gone terribly wrong here: ");
                    System.out.println(NPE);
                }                
            }
            else {
                try {
                    System.out.println(io.stripFileParent(file));
                }
                catch (NullPointerException NPE) {
                    System.out.println("Null Pointer Exception. Something has gone terribly wrong here: ");
                    System.out.println(NPE);
                }                
            }
        }
}
    
    public static void quit () {
        System.out.println("Goodbye!");
        System.exit(0);
    }
    
    public static void read (String argumentOne) {
        try {io.printFile(argumentOne);
            }
        
        catch (IOException IOE) {
            System.out.println("I/O Error");
            }
    }
    public static void su (String user) {
        
        if (user.isEmpty()) {
            shell.user.main("root");
        }
        
        else {
            shell.user.main(user);
        }
    }
    public static void sysInfo () {
        System.out.println("Operating System: " + OSUtils.getOS());
        System.out.println("Architecture: " + OSUtils.getArch());
        System.out.println("Java Version: " + System.getProperty("java.version"));
    }
    
    public static void sysExec (String command, String arg) {
        if (command.startsWith(".")) {
            command = command.replace("./", shell.io.getCurrentDir().toString());
            System.out.println("[Debug exec] command: " + command);
        }

        ProcessBuilder pb = new ProcessBuilder(command, arg);

        /*Map<String, String> env = pb.environment();
        env.put("VAR1", "myValue");
        env.remove("OTHERVAR");
        env.put("VAR2", env.get("VAR1") + "suffix");*/
        pb.directory(shell.io.getCurrentDir());


        
        try {
            Process p = pb.start();
        }
        catch (IOException IOE) {
            System.out.println("Failed to launch process (IOE)");
        }
        
    }
}