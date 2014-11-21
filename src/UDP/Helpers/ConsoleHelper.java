package UDP.Helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cccp on 21/11/2014.
 */
public class ConsoleHelper {
    public static String getInput() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }
}
