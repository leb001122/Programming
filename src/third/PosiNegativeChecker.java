package third;

import java.util.Scanner;

public class PosiNegativeChecker {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number? ");
        int num = sc.nextInt();

        if(num == 0)
            System.out.print(num +" is Even number");
        else if(num%2 == 0)
            PositiveNegativeCheck(num, "Even");
        else
            PositiveNegativeCheck(num, "Odd");
    }

    public static void PositiveNegativeCheck(int num, String s){
        if(num > 0)
            System.out.print(num + " is "+ s +" and Positive number");
        else if(num < 0)
            System.out.print(num + " is "+ s +" and Negative number");
    }
}
