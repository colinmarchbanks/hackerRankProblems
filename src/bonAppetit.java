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

public class Solution {

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int indexToExclude, int charged) {
        int sum = 0;
        for(int x = 0; x<bill.size();x++){
            if(x == indexToExclude){
                continue;
            }
            sum += bill.get(x);
        }
        if(charged > sum/2){
            System.out.println(charged - sum/2);
        }else{
            System.out.println("Bon Appetit");
        }



    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
