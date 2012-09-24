/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;
import java.io.*;

public class user
{
//    private static String authFile = System.getProperty("user.home") + OSUtils.getFileSeparator() + ".jshell" + OSUtils.getFileSeparator() + "auth.cfg";
    private static String authFile = System.getProperty("user.dir") + OSUtils.getFileSeparator() + "auth.cfg";
    private static String username = "";
    private static String password = "";

    public static void main (String user) {
        resetUserVars();
        login(user);
    }
    
    public static void login (String user) {
//    System.out.println("[Debug] Auth File: " + authFile);        
        int countDown = 3;
        try {
            while (!(checkPassword(username) == true )) {
                //System.out.println("countDown: " + countDown);
                if (countDown < 3 && countDown > 0) {
                    System.out.println("Your username or password was incorrect, please try again.");
                }

                else if (countDown == 0) {
                    System.out.println("Login attempt limit reached.");
                    main("login");
                }

                if (user.equals("login")) {
                        System.out.print("Username: ");
                        username = main.keyboardOne.nextLine();
                    }

                else {
                        username = user;
                }

                System.out.print("Password: ");
                password = main.keyboardOne.nextLine();
                countDown--;
                }
        }
        catch (IOException IOE) {
            System.out.println("Failed to check username, does the auth file exist?");
        }        
        catch (NullPointerException NPE) {
            System.out.println("Failed to check username (NPE).");
        }
        catch (ArrayIndexOutOfBoundsException AIooBE) {
            System.out.println("[Debug] Array index out of bounds");
        }        

        shell.jshell.main();
    }

    public static String getUsername () {
        return username;
    }
    
    public static Boolean checkPassword (String user) throws IOException {
        boolean valid = false;
        //System.out.println("[DEBUG] user::checkPassword::Reading Password Array.");
        String authArray[] = io.file.readFile(authFile);
        //System.out.println("[DEBUG] user::checkPassword::Success.");
        //        System.out.println(authArray[1]);
        for (int c=0;c!=authArray.length;c++) {
            String[] checkThis = (authArray[c]).split(":");
//            System.out.println("[Debug] checkThis[0]:" + checkThis[0]);
//            System.out.println("[Debug] checkThis[1]:" + checkThis[1]);

            if (checkThis[0].equals(username) && checkThis[1].equals(password)) {
                valid = true;
            }
        }
        
        return valid;
    }

/*    public static void setPassword (String user, String password) {
        if (user.equals("root")) {
            rootPassword = password;
        }
        
        else if (user.equals("dan")) {
            danPassword = password;
        }
        
        else {
            System.out.println("Unknown User");
        }
    
    } */
    
    public static void resetUserVars () {
        username = "";
        password = "";
        //currentUser = "";
    }
}

