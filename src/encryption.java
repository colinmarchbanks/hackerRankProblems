import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        String sentence = s;
        String toReturn = "";
        int rows = (int) Math.sqrt(sentence.length());

        int columns = (sentence.length() > rows*rows) ? rows+1 : rows;

        rows = (sentence.length() > rows*columns) ? rows+1 : rows;

        for(int i = 0; i < columns; i++)
        {
            int currentIndex = i;
            for(int j = 0; j < rows; j++)
            {
                if(currentIndex <= sentence.length()-1)
                {
                    toReturn += (sentence.charAt(currentIndex));
                }
                currentIndex += columns;
            }
            if(i+1 != columns) toReturn += (" ");
        }
        return toReturn;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
