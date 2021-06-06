package seventh;

import java.util.Scanner;

public class SumInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 0;
        int [] array = new int[10];

        for(int i=0; i<10; i++) {
            System.out.print("숫자 입력? ");
            int num = sc.nextInt();
            if(num<=0)
                break;

            array[idx] = num;
            idx++;
        }

        int sum = 0;
        for(int i=0; i<idx-1; i++) {
            System.out.print(array[i] + " + ");
            sum += array[i];
        }
        System.out.print(array[idx-1]+" = "+(sum+array[idx-1]));
    }
}
