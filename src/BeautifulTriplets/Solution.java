package BeautifulTriplets;

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
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
        // Write your code here
        //Removing Duplicates
        for(int i = 0 ; i < arr.size()-1; i++){
            if(arr.get(i) == arr.get(i+1)){
                arr.remove(i+1);
            }
        }
        int count =0;
        for(int i = 0; i < arr.size()-2; i++){
            for(int x = i+1; x < arr.size()-1; x++){
                int dif1 = 0;
                for(int y = x+1; y < arr.size(); y++){
                    dif1 = arr.get(x) - arr.get(i);
                    int dif2 = arr.get(y) - arr.get(x);
                    if(dif1 == d && dif2 == d)
                        count++;
                    if(dif2 > d){
                        break;
                    }
                }
                if(dif1 > d){
                    break;
                }
            }
        }
        return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
