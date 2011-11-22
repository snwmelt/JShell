/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

public class jgrep {
    //[FixMe] Really needs fixing
    public static void main (String args) {
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
}
