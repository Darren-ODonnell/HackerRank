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

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        String str = "";

        for(int i = p; i < q; i++){
            int sqr = i*i;

            String number = String.valueOf(sqr);
            
            String[] digits = {number.substring(0,number.length()/2 ) ,
                                number.substring(number.length()/2, number.length()-1)};
            int temp = Integer.parseInt(digits[0]) + Integer.parseInt(digits[1]);


            if(temp == i){ //keprekar Number
                str += temp;
                str += " ";
            }
        }

        System.out.println(str);

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
