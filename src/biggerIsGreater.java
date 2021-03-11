import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String a) {
        int ctr = 0;
        String out = "";
        char[] aCArr = a.toCharArray();
        int aLen = aCArr.length;
        int swap2 = 0;
        for (int i = aLen-2; i>=0; i--){
            int index = i;
            char aVal = aCArr[index];

            for (int j = index+1; j <= aLen-1; j++){
                if (aVal < aCArr[j]){
                    int swap1 = i;
                    ctr = i;
                    int local = i;
                    char base = 'a';
                    int cnt = 1;
                    for (int m = local+1; m < aLen; m++){
                        if (aCArr[m] > aCArr[swap1] && aCArr[m] < base || cnt == 1){
                            base = aCArr[m];
                            swap2 = m;
                            cnt++;
                        }
                    }



                    char temp = aCArr[swap1];
                    aCArr[swap1] = aCArr[swap2];
                    aCArr[swap2] = temp;

                    for (char k:aCArr){
                        out = out+k;
                    }
                    out = SubstringSort(out, ctr);
                    return out;
                }

            }
        }
        return "no answer";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

    public static String SubstringSort(String a, int ctr){

        String sub1 = a.substring(ctr+1, a.length());
        String sub2 = a.substring(0,ctr+1);
        char[] sub1Arr = sub1.toCharArray();
        String out = "";
        Arrays.sort(sub1Arr);

        for (char k:sub1Arr){
            out = out+k;
        }
        out = sub2+out;

        return out;
    }
}
