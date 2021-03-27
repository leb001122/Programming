package fifth;

import java.util.Scanner;

public class Factorial {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input number? ");
        int num = sc.nextInt();

        System.out.printf("%d! = ", num);

        int result = 1;
        for(int i = num; i > 1; i--) {
            System.out.printf("%d * ", i);
            result *= i;
        }

        System.out.printf("1 = %d", result);

        sc.close();
    }
}
