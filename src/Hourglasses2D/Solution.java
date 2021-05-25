package Hourglasses2D;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int max = 0;
        for(int row = 0; row < arr.size()-2; row++){
            for(int col = 0; col < arr.get(row).size()-2; col++){
                //Top row
                int resultTotal = 0;
                resultTotal  += arr.get(row).get(col);
                resultTotal  += arr.get(row).get(col+1);
                resultTotal  += arr.get(row).get(col+2);

                //Middle Row
                resultTotal  += arr.get(row+1).get(col+1);

                //Bottom Row
                resultTotal  += arr.get(row+2).get(col);
                resultTotal  += arr.get(row+2).get(col+1);
                resultTotal  += arr.get(row+2).get(col+2);

                if(row == 0){
                    max = resultTotal;
                }
                if(resultTotal > max){
                    max = resultTotal;
                }

            }
        }
        System.out.println(max);
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
