package JooNi;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("2진수 입력 : ");
        String binary = sc.nextLine();

        int leng = binary.length();
        String []array = binary.split("");
        int decimal = 0;

        for(int i=0; i<leng; i++)
        {
            decimal += Integer.parseInt(array[i]) * (int)Math.pow(2, leng-(i+1));
        }
        System.out.println("10진수 출력 : "+decimal);

    }
}
