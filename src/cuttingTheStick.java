import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        ArrayList<Integer> numCuts = new ArrayList<Integer>();
        Arrays.sort(arr);
        int sticksLeft = arr.length;

        int curr = arr[0];
        int currCount = 0;
        numCuts.add(sticksLeft);

        for(int i = 0; i < arr.length; i++)
        {
            if(curr == arr[i])
            {
                currCount++;
            }
            else
            {
                sticksLeft -= currCount;
                currCount = 1;
                curr = arr[i];
                numCuts.add(sticksLeft);
            }
        }
        int[] toReturn = new int[numCuts.size()];
        for(int i = 0; i < numCuts.size();i++){
            toReturn[i] = numCuts.get(i);
        }
        return toReturn;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
