package BinaryConverter;

import java.util.Scanner;

//your code goes here

public class Program {

    public static void main(String[ ] args) {
        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
        for(int i = 0; i < 1000; i++) {
            System.out.println(i + " : " +Converter.toBinary(i));
        }
    }
}