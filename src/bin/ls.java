/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;
import java.io.*;

public class ls {
        public static void main (String argumentOne, String argumentTwo) throws IOException, NullPointerException {
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

            if (shell.io.isPathRelative(argumentTwo) == true) {
                            dir = shell.io.getCurrentDir();
            }

         else if (shell.io.isPathRelative(argumentTwo) == false) {
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
                             System.out.println(file);
                     }
                    else {
                        System.out.println("Argument not recognised.");
                    }
                }
                else if (shell.io.isPathRelative(argumentTwo)) {
                        System.out.println("." + shell.io.stripFileParent(file));
                }
                else if (shell.OSUtils.getRootName(file).equals(file.toString())) {
                        System.out.println(shell.OSUtils.getRootName(file));
                }
                else {
                        System.out.println(shell.io.stripFileParent(file));
                }
            }
    }    
}