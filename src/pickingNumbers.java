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
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int firstValue = 0;
        int secondValue = 0;
        int test = 0;
        int total = 0;
        for(int x = 0; x < a.size();x++){
            if(test != a.get(x)){
                test = a.get(x);
                System.out.println(test);
                if(x != 0 && a.get(x) - a.get(x-1) > 1){
                    secondValue = 0;
                }else{
                    secondValue = firstValue;
                }
                firstValue = 1;
                if(total < firstValue + secondValue){
                    total = firstValue + secondValue;
                }
                System.out.println("Total = " + total);

            }else{
                firstValue++;
                if(total < firstValue + secondValue){
                    total = firstValue + secondValue;
                }
            }
        }
        return total;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
