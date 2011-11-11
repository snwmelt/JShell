/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

public class sysInfo {
    public static void main () {
        System.out.println("Operating System: " + shell.OSUtils.getOS());
        System.out.println("Architecture: " + shell.OSUtils.getArch());
        System.out.println("Java Version: " + System.getProperty("java.version"));
    }    
}
