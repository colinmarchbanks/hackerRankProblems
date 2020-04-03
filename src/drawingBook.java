import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int minNum = 0;
        int forward = 0;
        int backward = 0;
        for(int x = 1; x < n; x+=2){
            if(x>=p){
                break;
            }
            forward += 1;
        }
        if(n % 2 == 0){
            for(int x = n; x>=0;x-=2){
                if(x<=p){
                    break;
                }
                backward += 1;
            }
        }else{
            for(int x = n-1; x>=0;x-=2){
                if(x<=p){
                    break;
                }
                backward += 1;
            }
        }

        if(forward < backward){
            System.out.println("forward" + forward + " and backward" + backward);
            return forward;
        }
        System.out.println("forward" + forward + " and backward" + backward);
        return backward;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
