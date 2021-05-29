package TimeInWords;
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

    static String timeInWords(int h, int m) {
        String result = "";
        if (m == 0) {
            result = getNumberInWords(h) + " o' clock";
        } else if (m >= 1 && m <= 30) {
            if (m == 1) {
                result = getNumberInWords(m) + " minute past " + getNumberInWords(h);
            } else if (m == 15) {
                result = "quarter past " + getNumberInWords(h);
            } else if (m == 30) {
                result = "half past " + getNumberInWords(h);
            } else {
                result = getNumberInWords(m) + " minutes past " + getNumberInWords(h);
            }
        } else { // m > 30
            if (m == 45) {
                result = "quarter to " + getNumberInWords(h+1);
            } else {
                result = getNumberInWords(60-m) + " minutes to " + getNumberInWords(h+1);
            }
        }
        return result;
    }

    private static String getNumberInWords(int n) {
        switch (n) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            case 20:
                return "twenty";
            default:
                if (n > 20 && n < 30) {
                    return getNumberInWords(20) + " " + getNumberInWords(n-20);
                } else {
                    return "Unhandled number: " + n;
                }
        }
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

