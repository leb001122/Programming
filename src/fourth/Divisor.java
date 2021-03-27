package fourth;

import java.util.Scanner;

public class Divisor {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input number? ");
        int num = sc.nextInt();

        System.out.print("Divisor : ");

        for(int i=1; i<=num; i++) {
            if (num % i == 0)
                System.out.print(i + " ");
        }

        sc.close();
    }
}
