package seventh;

import java.util.Scanner;

public class Shift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 10;
        System.out.print("10개 숫자 입력? ");
        int [] array = new int[size];
        for(int i=0; i<size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("이동 방향 <왼쪽 L, 오른쪽 R>? ");
        char ch = sc.next().charAt(0);
        System.out.print("이동값? ");
        int val = sc.nextInt() % size;

        if(ch=='L') {
            for(int x=val, i=0; i<size; i++, x++) {
                if(i<size-val)
                    System.out.print(array[x]+" ");
                else
                    System.out.print(array[x%size]+" ");
            }
        }
        else if(ch=='R') {
            for(int x=size-val, i=0; i<size; i++, x++) {
                if(i<val)
                    System.out.print(array[x]+" ");
                else
                    System.out.print(array[x%size]+" ");
            }
        }
    }
}
