package sixth;

import java.util.Scanner;

public class FactorialFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자 입력? ");
        int num = sc.nextInt();
        if(num<0) return;

        System.out.printf("%d! = %d", num, Fibonacci(num));
    }

    public static int Fibonacci(int num) {
        if(num<2) return 1;
        return num * Fibonacci(num-1);
    }
}
