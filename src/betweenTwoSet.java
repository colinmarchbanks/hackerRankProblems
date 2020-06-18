import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int totalX = 0;
        Collections.sort(b);
        int smallestB= b.get(0);
        System.out.println("Smallest b = " + smallestB);
        List<Integer> products = new ArrayList();
        for(int x = smallestB;x>0;x--){
            boolean isProduct = true;
            for(int y = 0;y<a.size();y++){
                if(x%a.get(y)!=0){
                    isProduct = false;
                }
            }
            if(isProduct){
                products.add(x);
            }
        }
        for(int x = 0;x<products.size();x++){
            boolean isFactor = true;
            for(int y = 0;y<b.size();y++){
                if(b.get(y)%products.get(x)!=0){
                    isFactor = false;
                }
            }
            if(isFactor){
                totalX++;
            }
        }
        System.out.println("Products = " + products);
        return totalX;


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
