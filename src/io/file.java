/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class file {
    //[Code] Improve
    
    public static String[] readFile (String file) throws IOException {
        String[] outputLines = null;
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(file)));
            int i = 1;
            while (s.hasNextLine()) {
                outputLines[i] = (s.nextLine());
                i++;
            }
        }
        
        finally {
            if (s!=null) {
                s.close();
            }
        }

        return outputLines;
    }    
    
    public static void printFile (String file) throws IOException {
        String fileArray[] = readFile(file);
        for (int c=0;c!=fileArray.length;c++) {
            System.out.println(fileArray[c]);
        }
    }
}
