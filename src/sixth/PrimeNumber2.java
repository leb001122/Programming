package sixth;

import java.util.Scanner;

public class PrimeNumber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("정수 입력 : ");
            int num = sc.nextInt();
            if (num<2)
                return;

            int res = 0;
            for (int i=2; i<=num; i++) {
                if (isPrime(i))
                    res++;
            }
            System.out.println("소수 개수 : " + res +"\n");
        }
    }

    public static boolean isPrime(int num) {
        for(int i=2; i<num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}


