package MigratoryBirds;

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

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer, Integer> list= new HashMap<>();

        for(int i = 0; i < arr.size(); i++) {
            if (!list.containsKey(arr.get(i))){
                list.put(arr.get(i), 1);
            }else{
                list.put(arr.get(i), list.get(arr.get(i)) + 1);
            }
        }
        final int[] max = {list.get(1)};
        int index = -1;
        final int[] value = {-1};

        list.forEach((k,v) -> {
            if(v > max[0]){
                max[0] = v;
                value[0] = k;
            }
            System.out.println("Key: "+k+", Sighting: "+v);
        });

        return value[0];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

