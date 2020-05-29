import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int firstDay, int lastDay, int divisor) {
        int numDays = 0;
        for(double i = firstDay;i <= lastDay; i++){
            Double numForward = i;
            String iString = Double.toString(i);
            String[] iSplit = iString.split("");
            String iReverse = new String();
            for(int y = iSplit.length-1; y>=0; y--){
                iReverse += iSplit[y];
            }
            double numReverse = Math.round(Double.parseDouble(iReverse) * Math.pow(10,iReverse.length()-2));
            if (Math.abs((numForward - numReverse)) / divisor - Math.floor((Math.abs(numForward - numReverse)) / divisor) == 0){
                numDays++;
            }
        }
        return numDays;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
