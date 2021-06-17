package FlatlandSpaceStation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        // c = amount of towns from 1- n
        // c = all indexes with a space station
        List<Integer> closestDistances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int closest = -1;

            for(int a = 0; a < c.length; a++) {
                if(closest == -1){
                    closest = c[0]-i;

                }

                if(Math.abs(c[a]-i) < closest){
                    closest = c[a]-i;
                }
                closest = Math.abs(closest);
                
            }
            closestDistances.add(closest);
        }
        Collections.sort(closestDistances);


        return closestDistances.get(closestDistances.size()-1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
