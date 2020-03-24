import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String[] timeSplit = s.split(":");
        if(Integer.parseInt(timeSplit[0]) == 12 && timeSplit[2].contains("AM")){
            return "00:" + timeSplit[1] + ":" + timeSplit[2].substring(0,2);
        }
        if(Integer.parseInt(timeSplit[0]) == 12 && timeSplit[2].contains("PM")){
            return "12:" + timeSplit[1] + ":" + timeSplit[2].substring(0,2);
        }
        if(timeSplit[2].contains("PM")){
            return Integer.parseInt(timeSplit[0]) + 12 + ":" + timeSplit[1] + ":" + timeSplit[2].substring(0,2);
        }
        return s.substring(0,8);

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
