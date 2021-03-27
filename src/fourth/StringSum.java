package fourth;

import java.util.Scanner;

public class StringSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input number 1 ? ");
        int num1 = sc.nextInt();
        System.out.print("Input number 2 ? ");
        int num2 = sc.nextInt();

        int sum = 0;

        if(num1>num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        for(int i=num1; i<=num2; i++) {
            sum += i;
        }

        System.out.print("작은 수부터 큰 수까지의 합 : "+sum);
        sc.close();
    }
}
