/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class file {
    //[Code] Improve
    //[Code] Dirty Hacks Everywhere.
    
    public static String[] readFile (String file) throws IOException {
        ArrayList<String> outputLines = new ArrayList();
        //String[] outputLines = null;
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(file)));
            int i = 1;            
            while (s.hasNextLine()) {
                outputLines.add(s.nextLine());                
            }
        }
        
        finally {
            if (s!=null) {
                s.close();
            }
        }

        String[] tempArray = new String[outputLines.size()];
        
        for (int i=0;i<outputLines.size();i++)
        {
            tempArray[i] = outputLines.get(i);
        }
        
        return tempArray;
    }    
    
    public static void printFile (String file) throws IOException {
        String fileArray[] = readFile(file);
        for (int c=0;c!=fileArray.length;c++) {
            System.out.println(fileArray[c]);
        }
    }
}
