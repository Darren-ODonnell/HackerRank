package javaLoops;

    import java.util.*;
import java.io.*;

    class Solution{
        public static void main(String []argh){
            Scanner in = new Scanner(System.in);
            int t=in.nextInt();
            for(int x=0;x<t;x++){
                int a = in.nextInt();
                int b = in.nextInt();
                int n = in.nextInt();

                int total = 0;
                for(int i = 0; i < n; i++){
                    if(total == 0){
                        total = a;
                    }
                    int add = (int) (Math.pow(2, i) * b);
                    total += add;
                    System.out.print(total + " ");
                }
                System.out.println();
            }


            in.close();
        }
    }
