package seventh;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("10진수 정수 입력<20억 이하> : ");
        int decimal = sc.nextInt();

        int [] array = new int[4];
        int cnt = 0;

        while(true) {
            array[cnt] = decimal % 2;
            decimal /= 2;
            if(decimal == 0)
                break;

            if(cnt+1==array.length)
                array = resize(array.length*2, array);
            cnt++;
        }

        System.out.print("2진수 변환 결과 : ");
        for(int i=cnt; i>=0; i--) {
            System.out.print(array[i]);
        }
    }

    public static int[] resize(int size, int[] array) {
        int [] newArray = new int[size];
        for(int i=0; i<size/2; i++)
            newArray[i] = array[i];

        return newArray;
    }
}
