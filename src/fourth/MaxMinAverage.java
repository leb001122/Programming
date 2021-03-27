package fourth;

import java.util.Scanner;

public class MaxMinAverage {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        int sum = 0;

        System.out.print("Input number? ");
        num = sc.nextInt();

        if(num == -1)
            return;

        while(num != -1) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;

            sum += num;
            cnt++;

            System.out.print("Input number? ");
            num = sc.nextInt();
        }

        double avg = (double)sum/cnt;

        System.out.println("최솟값 : "+min);
        System.out.println("최댓값 : "+max);
        System.out.println("평균값 : "+avg);

        sc.close();
    }
}
