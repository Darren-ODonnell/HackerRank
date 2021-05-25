package TimeConversion;

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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        //12:00:00PM" -> 12:00:00
        //01:00:00PM" -> 13:00:00
        //12:00:00AM" -> 00:00:00
        //01:00:00AM" -> 01:00:00
        String[] parts = s.split(":");
        String[] finalParts = new String[2];

        finalParts[0] = s.substring(6,7);
        finalParts[1] = s.substring(8,9);
        // finalParts[0] = parts[2].substring(0,1);
        // finalParts[1] = parts[2].substring(2,3);


        int hours = 0;

        if(s.charAt(8) == 'P') {
            hours = 12;

            if (!parts[0].equals("12")){
                hours += Integer.parseInt(parts[0]);
            }
        }else{
            if (!parts[0].equals("12")){
                hours = Integer.parseInt(parts[0]);
            }
        }
        String hoursStr;
        if(hours < 10){
            hoursStr = "0" + hours;
        }else{
            hoursStr = String.valueOf(hours);
        }

        return hoursStr + ":" + parts[1] + ":" + parts[2].charAt(0) + parts[2].charAt(1);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

