package sixth;

import java.util.Scanner;

public class PrimeNumber1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("정수 입력 : ");
            int num = sc.nextInt();
            if(num < 1)
                return;

            if (isPrime(num))
                System.out.printf("입력된 정수 %d는 소수임\n", num);
            else
                System.out.printf("입력된 정수 %d는 소수 아님\n", num);
        }
    }

    public static boolean isPrime(int num) {
        if(num == 1)
            return false;

        for(int i=2; i<num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
