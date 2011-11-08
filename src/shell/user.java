/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

public class user
{
    private static String username = "";
    private static String password = "";
    private static String currentUser = "";

    public static void login (String user) {
        boolean firstTime = true;
        while (!(username.equals("root") && password.equals("password"))) {
            if (firstTime == false) {
                System.out.println("Your username or password was incorrect, please try again.");
            }
            if (user.equals("initial")) {
                    System.out.print("Username: ");
                    username = main.keyboardOne.nextLine();
                }
           
            else {
                    username = user;
            }
           // System.out.println("[Debug] username " + username);
            System.out.print("Password: ");
            password = main.keyboardOne.nextLine();
            //System.out.println("[Debug] pass " + password);
            firstTime = false;
        }
    }    

    public static String getUsername () {
        return username;
    }    
}
