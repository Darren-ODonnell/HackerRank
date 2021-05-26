package ShortestStick;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

    public class Solution {

        // Complete the cutTheSticks function below.
        static int[] cutTheSticks(int[] arr) {

            //You are given a number of sticks of varying lengths.
            // You will iteratively cut the sticks into smaller sticks,
            // discarding the shortest pieces until there are none left.
            // At each iteration you will determine the length of the shortest stick remaining,
            // cut that length from each of the longer sticks and then discard all the pieces of that shortest length.
            // When all the remaining sticks are the same length, they cannot be shortened so discard them.
            //
            //Given the lengths of n sticks, print the number of sticks that are left before each iteration
            // until there are none left.

            int min = arr[0];

            //get smallest stick from array
            while(arr.length > 0){
                for(int i = 1; i < arr.length; i++){
                    if(i < min){
                        min = i;
                    }
                }
                // cut all sticks down to size
                for(int i = 0; i < arr.length; i++){
                    arr[i] -=min;
                }
                //remove all which are the shortest
                int[] temp = new int[arr.length];
                for(int i = 0; i < arr.length; i++){

                    if(arr[i] != min){
                        temp[i] = arr[i];
                    }
                }
                arr = temp;
            }

            return arr;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = cutTheSticks(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }

