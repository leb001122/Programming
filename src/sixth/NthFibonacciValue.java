package sixth;

import java.util.Scanner;

public class NthFibonacciValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력 : ");
        int nth = sc.nextInt();
        if(nth<1)
            return;

        System.out.print("피보나치 수열 값 : "+fibonacci(nth));
    }

    public static int fibonacci(int nth)
    {
        if(nth==0)
            return 0;
        if(nth==1)
            return 1;

        int res = 0;
        for(int v1=0, v2=1, i=0; i<nth-2; i++) // for문의 반복횟수 == 연산횟수
        {
            res = v1 + v2;
            v1 = v2;
            v2 = res;
        }
        return res;
    }
}
