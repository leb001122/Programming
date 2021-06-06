package seventh;

import java.util.Scanner;

public class Set {
    static int [] B = new int[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("집합 A 입력 : ");
        int [] A = new int[5];
        int sizeA = 0;

        for(int i=0; ; i++) {
            int num = sc.nextInt();

            if(num==-1)
                break;
            if(i == A.length)
                A = resize(A.length*2, A);

            A[i] = num;
            sizeA++;
        }

        System.out.print("집합 B 입력 : ");
        int [] B = new int[5];
        int sizeB = 0;

        for(int i=0; ; i++) {
            int num = sc.nextInt();

            if(num==-1)
                break;
            if(i == B.length)
                B = resize(B.length*2, B);

            B[i] = num;
            sizeB++;
        }

        System.out.println("합집합 : < "+union(A, B, sizeA, sizeB)+">");
        System.out.println("교집합 : < "+intersection(A, B, sizeA, sizeB)+">");
        System.out.println("차집합 : < "+difference(A, B, sizeA, sizeB)+">");
    }

    public static String union(int [] A, int [] B, int sizeA, int sizeB) {
        String str = "";

        for(int i=0; i<sizeA; i++)
            str += A[i]+" ";

        Outer :
        for(int i=0; i<sizeB; i++) {
            for(int j=0; j<sizeA; j++) {
                if(A[j] == B[i])
                    continue Outer;
            }
            str += B[i]+" ";
        }
        return str;
    }

    public static String intersection(int [] A, int [] B, int sizeA, int sizeB) {
        String str = "";

        for(int i=0; i<sizeA; i++) {
            for(int j=0; j<sizeB; j++) {
                if(A[i] == B[j]) {
                    str += A[i]+" ";
                    break;
                }
            }
        }
        return str;
    }

    public static String difference(int [] A, int [] B, int sizeA, int sizeB) {
        String str = "";

        Outer :
        for(int i=0; i<sizeA; i++) {
            for(int j=0; j<sizeB; j++) {
                if(A[i] == B[j])
                    continue Outer;
            }
            str += A[i]+" ";
        }

        return str;
    }

    public static int[] resize(int size, int[] array) {
        int [] newArray = new int[size];
        for(int i=0; i<size/2; i++)
            newArray[i] = array[i];

        return newArray;
    }
}
