/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

public class jshell
{
    private static String command = "";
    private static String argumentOne = "";
    private static String argumentTwo = "";
    private static String argumentThree = "";
    //private static String argumentTwo = "";
    
    public static void main () {
        while (!(command.equals("logout"))) {
            System.out.print(getPromptPrefix());
            String commandAndArguments = main.keyboardOne.nextLine();
            
            String[] caArray = {"","","","",""};
            String[] caTempArray = commandAndArguments.split(" ");
            for (int t = 0;t<caTempArray.length;t++) {
                caArray[t] = caTempArray[t];
            }
        

          //System.out.println("[Debug JShell] Command: " + caArray[0]);
          //System.out.println("[Debug JShell] Arg1: " + caArray[1]);
          exec.main(caArray[0], caArray[1], caArray[2], caArray[3], caArray[4]);
        }
    }

    private static String getPromptPrefix() {
        String prompt = (user.getUsername() + ":" + " " + shell.io.getCurrentDir() + "  - ");
        return prompt;
    }
}