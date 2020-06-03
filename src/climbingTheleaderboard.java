import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int n = scores.length;
        int m = alice.length;
        int[] rank = new int[n];
        int[] bucket = new int[m];

        rank[0] = 1;

        for(int i=1;i<n;i++){

            if(scores[i] < scores[i-1]){

                rank[i] = rank[i-1] + 1;

            }else{

                rank[i] = rank[i-1];

            }

        }

        int start = 0,end = n-1;

        int ind;

        for(int i=0;i<m;i++){

            ind = binarySearch(scores, start, end, alice[i]);

            if(ind==-1){
                bucket[i] = rank[n-1]+1;
                System.out.println(rank[n-1]+1);

            }else{

                end = ind;
                bucket[i] = rank[ind];
                System.out.println(rank[ind]);

            }

        }
        return bucket;
    }

    static int binarySearch(int[] s, int start, int end, int alice){

        if(alice<s[end]) return -1;

        if(alice>=s[start]) return 0;

        if(end-start<=1) return end;

        int mid = (start+end)/2;

        if(s[mid]<alice){

            return binarySearch(s,start, mid,alice);

        }else if(s[mid] == alice){

            return mid;

        }else{

            return binarySearch(s,mid,end,alice);

        }



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

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
