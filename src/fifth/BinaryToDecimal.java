package fifth;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Binary number? ");
        int binary = sc.nextInt();
        int decimal = 0;

        for(int i=0; binary!=0; i++)
        {
            decimal += binary%10 * (int)Math.pow(2, i);
            binary = binary/10;
        }
        System.out.println("Decimal Number : "+decimal);

        sc.close();
    }
}
