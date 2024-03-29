package BetweenTwoSets;

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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        //Elements of first array are all factors of num
        boolean valid;
        List<Integer> multiples = new ArrayList<>();
        List<Integer> factors = new ArrayList<>();


        //Get factors
        for (int i = 1; i <= b.get(0); i++) {
            valid = true;
            for (int x = 0; x < b.size(); x++) {
                if (b.get(x) % i != 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                factors.add(i);
            }
        }

        //get Multiples
// Since factors are added low first, big last the last number is the greatest
        for (int i = 1; i < 1000; i++) {
            valid = true;
            if (i % a.get(0) == 0) {
                for (int x = 1; x < a.size(); x++) {
                    if (i % a.get(x) != 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    multiples.add(i);
                }
            }
        }
        System.out.println("Factors");
        for (int i = 0; i < factors.size(); i++) {
            System.out.println(factors.get(i));
        }
        System.out.println("Multiples");
        for (int i = 0; i < multiples.size(); i++) {
            System.out.println(multiples.get(i));
        }

        int count = 0;

        for (Integer factor : factors) {
            if (multiples.contains(factor)) {
                count++;
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

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
