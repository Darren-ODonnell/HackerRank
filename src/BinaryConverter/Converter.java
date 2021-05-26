package BinaryConverter;

public class Converter {

    public static int toBinary(int num){
        String binary="";
        if(num == 0)
            return 0;

        if(num < 0)
            return 0;

        while(num > 0) {
            binary = (num%2)+binary;
            num /= 2;
        }

        return Integer.parseInt(binary);
    }
}


