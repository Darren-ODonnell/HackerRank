package Encryption;

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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

//    haveaniceday

    //have
    //anic
    //eday
    // hae and via ecy

    public static String encryption(String s) {
        // Write your code here
        //takes out spaces
        int len = s.replace(" ", "").length();

        int rows = (int) Math.floor(Math.sqrt(len));

        int cols = (int) Math.ceil(Math.sqrt(len));

        String str = "";
        String grid = "";

        char[][] strArray = new char[cols][rows];
        for(int col = 0; col < cols; col++){
            for(int row = 0; row < rows; row++){

                int index = (row * cols) + col;
                strArray[col][row] = s.charAt(index);
                grid += s.charAt(index);
            }
            grid += " ";
        }
        return grid;
//        System.out.println(grid);
//
//        for (int row = 0; row < rows; row++) {
//            for(int col = 0; col < cols; col++) {
//                str += strArray[col][row];
//            }
//            str+= "\n";
//        }
//        System.out.println(str);
//        return str;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
