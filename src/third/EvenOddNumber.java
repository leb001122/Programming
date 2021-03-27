package third;

import java.util.Scanner;

public class EvenOddNumber {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number? ");
        int num = sc.nextInt();

        if(num%2 == 0)
            System.out.print(num +" is Even number");
        else
            System.out.print(num +" is Odd number");
    }
}
