/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

public class user
{
    private static String username = "";
    private static String password = "";
    private static String rootPassword = "password";
    private static String danPassword = "cake";
    //private static String currentUser = "";

    public static void main (String user) {
        resetUserVars();
        login(user);
    }
    
    public static void login (String user) {
        int countDown = 3;
        while (!((username.equals("root") && password.equals(rootPassword)) || (username.equals("dan") && password.equals(danPassword)))) {
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
        shell.jshell.main();
        
    }    

    public static String getUsername () {
        return username;
    }    

    public static void setPassword (String user, String password) {
        if (user.equals("root")) {
            rootPassword = password;
        }
        
        else if (user.equals("dan")) {
            danPassword = password;
        }
        
        else {
            System.out.println("Unknown User");
        }
    
    }
    
    public static void resetUserVars () {
        username = "";
        password = "";
        //currentUser = "";
    }
}

