package ua.com.sourceit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: alexkorotkikh
 * Date: 12/14/13
 * Time: 12:04 PM
 */
public class Utils {
    public static String readFromFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }

}
