package AppleOranges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countApplesAndOranges function below.
//    s: integer, starting point of Sam's house location.
//    t: integer, ending location of Sam's house location.
//    a: integer, location of the Apple tree.
//    b: integer, location of the Orange tree.
//            apples: integer array, distances at which each apple falls from the tree.
//            oranges: integer array, distances at which each orange falls from the tree.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

        int appleCount = 0;
        int orangeCount = 0;

        int appleDist = 0;
        int orangeDist = 0;

        appleCount = countFruit(s,t,a,apples);
        orangeCount = countFruit(s,t,b,oranges);

        System.out.println(appleCount);
        System.out.println(orangeCount);

    }

    private static int countFruit(int s, int t, int a, int[] fruit) {
        int count = 0;
        int distance = 0;

        for(int i = 0; i < fruit.length; i++){
            distance = fruit[i] + a;
            if(distance >= s && distance <= t){
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);



    public static void applesAndOranges() {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();

    }

    public static void main(String[] args) {

        applesAndOranges();

    //        int[] apples = {-2,2,1};
    //        int[] oranges = {5,-6};
    //        int houseStart = 7;
    //        int houseEnd = 11;
    //        int aTree = 5;
    //        int oTree = 15;
    //
    //
    //        countApplesAndOranges( houseStart,  houseEnd,  aTree,  oTree,  apples,  oranges);

    }
}
/**
 * count apples was correct but count oranges was incorrect.
 * changes
 * orangeDist = b - oranges[i] ;
 * orangeDist = oranges[i] + b;
 *
 */

