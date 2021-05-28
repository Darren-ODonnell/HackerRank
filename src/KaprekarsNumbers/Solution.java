package KaprekarsNumbers;

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
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    //1 9 45 55 99

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        boolean found = false;
        for(long i = p; i <= q; i++) {
            String sqr = Long.toString(i * i);
            int d = sqr.length() - Long.toString(i).length();
            int l = 0, r = 0;
            if(d >= 0)
                r = Integer.parseInt(sqr.substring(d));
            if(d > 0)
                l = Integer.parseInt(sqr.substring(0, d));
            if(r + l == i) {
                found = true;
                System.out.print(i + " ");
            }
        }

        if(!found)
            System.out.println("INVALID RANGE");
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
