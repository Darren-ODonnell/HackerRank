package DrawingBook;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int pageTurns = 0;
        // n = pages in book
        // p = page to turn to
        if(p == n -1 && n%2 == 0 && n > 2){
            pageTurns = 1;
        }else if(p <= n / 2 ){
            //Start from beginning -> work forward
            pageTurns = p / 2;
        }else{
            //Start from end -> work back
            pageTurns = (n - p) / 2;

        }
        return pageTurns;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
