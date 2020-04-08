import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int current = 0;
        int numValleys = 0;
        boolean isValley = false;
        String[] sSplit = s.split("");
        for(int x = 0; x < sSplit.length;x++){
            if(sSplit[x].equals("U")){
                current ++;
            }
            if(sSplit[x].equals("D")){
                current --;
            }
            if(current < 0){
                isValley = true;
            }
            if(current == 0 && isValley){
                numValleys ++;
                isValley=false;
            }
        }
        return numValleys;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
