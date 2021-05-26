package SherlockAndSquares;

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
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */

    public static int squares(int a, int b) {
        // Write your code here

        //between a and b how many squares are there
        int count = 0;

        // get square root of a
        double sqrtA = Math.sqrt(a);

        //get whole roots after a
        if(sqrtA % 1 == 0){
            count++;
        }
        long sqrt = Math.round(sqrtA);

        for(long i = sqrt; i <= Math.sqrt(b); i++){
            long squared = i*i;
            if(a < squared && squared <= b){
                count++;
            }
        }
        return count;

//
//        //check if the square of the whole roots are within range
//        for(int i = a; i <= b; i++){
//
//            if(Math.sqrt(i) % 1 == 0){ // Whole number
//
//                count++;
//            }
//        }
//        return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.squares(a, b);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
