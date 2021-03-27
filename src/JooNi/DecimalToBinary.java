package JooNi;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int decimal = sc.nextInt();
        int share = decimal;
        String remainder = "";

        do{
            remainder += Integer.toString(share%2);
            share /= 2;
        }while(share != 0);

        for(int i=remainder.length()-1; i>=0; i--){
            System.out.print(remainder.charAt(i));
        }

    }

}
