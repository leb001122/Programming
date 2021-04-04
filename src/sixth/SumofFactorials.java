package sixth;

import java.util.Scanner;

public class SumofFactorials {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력? ");
        int num = sc.nextInt();
        if(num<2)
            return;

        System.out.println(printFactorials(num) + sumFactorials(num));
    }

    public static String printFactorials(int num)
    {
        String str = "";
        for(int i=1; i<num-1; i++)
            str += i+"! + ";
        str += num-1+"! = ";

        return str;
    }

    public static int sumFactorials(int num)
    {
        int res = 1;
        for(int n=2; n<num; n++)
        {
            int temp = 1;
            for(int i=2; i<=n; i++)
                temp *= i;
            res += temp;
        }
        return res;
    }
}
