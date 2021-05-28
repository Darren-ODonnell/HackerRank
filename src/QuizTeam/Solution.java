package QuizTeam;

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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {

        // Write your code here

        //Get teams
        List<Integer> team = new ArrayList<>();
        int amount = topic.get(0).length();

        for(int i = 0; i < topic.size()-1; i++){
            for(int x = i+1; x < topic.size(); x++){

                int len = 0;
                for(int chr = 0; chr < amount; chr++){

                    if(topic.get(i).charAt(chr) == '1'|| topic.get(x).charAt(chr) == '1'){
                        len++;
                    }

                }
                team.add(len);

            }
        }

        //Get Max topics
        int maxCount = 0;
        Collections.sort(team);
        int max = team.get(team.size()-1);

        int i = team.size()-1;
        while(team.get(i) == max){
            maxCount++;
            i--;
        }

        List<Integer> newList = new ArrayList<>();
        newList.add(max);
        newList.add(maxCount);

        return newList;

//        // Write your code here
//
//        //Get teams
//        List<String> team = new ArrayList<>();
//        int amount = topic.get(0).length();
//
//        for(int i = 0; i < topic.size()-1; i++){
//            for(int x = i+1; x < topic.size(); x++){
//
//                String str = "";
//                for(int chr = 0; chr < amount; chr++){
//
//                    if(topic.get(i).charAt(chr) == '1'|| topic.get(x).charAt(chr) == '1'){
//                        str += '1';
//                    }
//
//                }
//                team.add(str);
//
//            }
//        }
//
//        //Get Max topics
//        int maxCount = 0;
//        Collections.sort(team);
//        int max = team.get(team.size()-1).length();
//
//        int i = team.size()-1;
//        while(team.get(i).length() == max){
//            maxCount++;
//            i--;
//        }
//
//        List<Integer> newList = new ArrayList<>();
//        newList.add(max);
//        newList.add(maxCount);
//
//        return newList;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
