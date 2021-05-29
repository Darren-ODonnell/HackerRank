package MinimumDistances;

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
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
        // Write your code here
        // Find min distance between same elements
        // return distance between elements or -1 if no matching elements
        int minDistance = -1;
        for(int i = 0 ; i < a.size()-1; i++){
            int count = 0;
            for(int x = i+1; x < a.size(); x++){
                count++;
                if(minDistance == -1 && a.get(i).equals(a.get(x))){
                    minDistance = count;
                }
                if(a.get(i).equals(a.get(x)) && count < minDistance){
                    minDistance = count;
                }
            }
        }
        return minDistance;

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

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
