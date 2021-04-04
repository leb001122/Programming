package sixth;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력? ");
        int num = sc.nextInt();

        System.out.printf("%d! = %d", num, factorial(num));
    }

    public static int factorial(int num) {
        int res = 1;
        for(int i=2; i<=num; i++)
            res *= i;

        return res;
    }
}
