package StrangeAdvertising;

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
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int viralAdvertising(int n) {

        // Write your code here

        int cumulativeLikes = 0;
        int shared = 0;
        int liked = 0;

        for(int day = 1; day <= n; day++){

            if(day == 1){//Day 1
                shared = 5;
                liked = shared/2;
                cumulativeLikes += liked;
            }else {
                //new shared = old shared /2 *3
                shared = (shared / 2) * 3;
                //liked = new shared / 2
                liked = shared / 2;
                //cumulative likes += liked;
                cumulativeLikes += liked;
                System.out.println("Shared: " + shared + "Liked: " + liked + "cumulativeLikes: " + cumulativeLikes);
            }
        }

        return cumulativeLikes;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
