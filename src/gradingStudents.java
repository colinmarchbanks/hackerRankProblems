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
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalList = new ArrayList<Integer>();
        for(int x = 0; x < grades.size();x++){
            if(grades.get(x) < 38){
                finalList.add(grades.get(x));
            }else if (grades.get(x) < 40 && grades.get(x) >= 38){
                finalList.add(40);
            }
            else if (grades.get(x) < 45 && grades.get(x) >= 43){
                finalList.add(45);
            }
            else if (grades.get(x) < 50 && grades.get(x) >= 48){
                finalList.add(50);
            }
            else if (grades.get(x) < 55 && grades.get(x) >= 53){
                finalList.add(55);
            }
            else if (grades.get(x) < 60 && grades.get(x) >= 58){
                finalList.add(60);
            }
            else if (grades.get(x) < 65 && grades.get(x) >= 63){
                finalList.add(65);
            }
            else if (grades.get(x) < 70 && grades.get(x) >= 68){
                finalList.add(70);
            }
            else if (grades.get(x) < 75 && grades.get(x) >= 73){
                finalList.add(75);
            }
            else if (grades.get(x) < 80 && grades.get(x) >= 78){
                finalList.add(80);
            }
            else if (grades.get(x) < 85 && grades.get(x) >= 83){
                finalList.add(85);
            }
            else if (grades.get(x) < 90 && grades.get(x) >= 88){
                finalList.add(90);
            }
            else if (grades.get(x) < 95 && grades.get(x) >= 93){
                finalList.add(95);
            }
            else if (grades.get(x) < 100 && grades.get(x) >= 98){
                finalList.add(100);
            }else{
                finalList.add(grades.get(x));
            }
        }
        return finalList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
