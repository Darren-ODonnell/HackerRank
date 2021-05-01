
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int a = 0;
        int b = 0;
        int n = 0;
        for(int i=0;i<t;i++){
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();
        }
        in.close();

        int total = 0;
        for(int i = 1; i <= n; i++){
            int temp = 0;
            temp += a;
            temp += (b * Math.pow(2,i));
            total += temp;
            System.out.print(total + " ");
        }
    }
}
