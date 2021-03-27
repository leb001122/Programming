package fifth;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        do
        {
            System.out.print("Input number? ");
            size = sc.nextInt();
        }while(size%2==0);

        for(int temp=0, middle=size/2, line=0; line<size; line++)
        {
            for(int i=temp; i<middle; i++)
                System.out.print(" ");
            for(int i=0; i<temp*2+1; i++)
                System.out.print("*");

            if(temp<middle && line<middle)
                temp++;
            else
                temp--;

            System.out.println();
        }
    }
}
