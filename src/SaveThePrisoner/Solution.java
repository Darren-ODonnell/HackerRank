package SaveThePrisoner;

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
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER s
     */
    static Node head, tail;

    public static int saveThePrisoner(int n, int m, int s) {
        //n = number of prisoners
        //m = number of sweets
        //s = chair number to start passing out sweets
        //return chair number of person to warn

        /**
         *  m % n = r; // if m less than n, r = m
         *  r + s = ss; // if greater than size, - size
         *  ss -= 1;
         *  return ss;
         */
        int r;
        int ss;
        if( m > n )
            r = m % n;
        else
            r = m;

        ss = r + s;

        if(ss > n + 1){
            ss -= n;
        }
        ss -=1;
        return ss;

    }

    private static void seatPrisoners(int n) {
        IntStream.range(1, n).forEach(Result::addNode);
    }

    public static void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {

        int mm,nn,ss,check;

        /**
         *  m % n = r; // if m less than n, r = m
         *  r + s = ss; // if greater than size, - size
         *  ss -= 1;
         *  return ss;
         */
//        nn=5;mm=5;ss=4;check=3;
        /*
        5 % 5 = 0
        0 + 4 = 4
        4 - 1 = 3
         */
//        nn=5;mm=2;ss=1;check=2;
        /*
        2 % 5 = 0 // less than 5 -> use 2 as is
        2 + 1 = 3
        3 - 1 = 2
         */
 
        nn=999999999;mm=999999999;ss=2;check=1;
        /*
        19 % 7 = 5;
        5 + 2 = 7; // if greater than size, - size
        7-1 = 6;
        */
//        n=3;m=7;s=3;check=3;
        /*
        7 % 3 = 1;
        1 + 3 = 4;
        4 - 1 = 3;
         */
//        n=5;m=8;s=4;check=1;
        /*
        8 % 5 = 3;
        3 + 4 = 7;
        7 > 5 -> 7-5 = 2;
        2 -1 = 1;
         */



//        int result2 = Result.saveThePrisoner(5, 5, 4); int check = 3;
//        int result2 = Result.saveThePrisoner(5, 2, 1); int check = 2;
//        int result2 = Result.saveThePrisoner(5, 8, 4); int check = 1;
//        int result2 = Result.saveThePrisoner(5, 5, 4); int check = 4;
//

        int result2 = Result.saveThePrisoner(mm, nn, ss);


        if(result2==check) {
            System.out.println("Success Result = "+result2);
        } else
            System.out.println("Fail! "+result2+" found - expected "+ check);

        System.out.println(result2);
        System.exit(0);


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int s = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.saveThePrisoner(n, m, s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }



}
class Node {

    int value;
    Node nextNode;

    public Node(int value) {
        this.value = value;
    }

}
