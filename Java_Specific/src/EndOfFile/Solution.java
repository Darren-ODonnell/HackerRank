package EndOfFile;

import java.io.EOFException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = "";
        int index = 1;

        while (scan.hasNext()) {
            System.out.println(index + " " + scan.nextLine());
            index++;
        }
    }
}
