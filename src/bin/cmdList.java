/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;
import java.lang.reflect.*;

public class cmdList {
    public static void main () {
            Method list[] = shell.exec.class.getDeclaredMethods();
            //i is set to 1 to avoid printing the inital array value as we do not want to include the main class in the output.
            for (int i = 1; i < list.length; i++) {
                String unparsedList = (list[i].toString());
                String prefixParsedList = unparsedList.replace("public static void shell.exec.", "");
                String parsedList[] = prefixParsedList.split("\\(");
                System.out.println(parsedList[0]);
            }        
    }    
}
