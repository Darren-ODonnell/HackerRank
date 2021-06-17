package JavaStringsIntroduction;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        int greater = A.compareTo(B);
        System.out.println(A.length() + B.length());

        if(greater <= 0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }

        System.out.print(A.substring(0,1).toUpperCase() + A.substring(1) + " ");
        System.out.print(B.substring(0,1).toUpperCase() + B.substring(1));

    }
}



