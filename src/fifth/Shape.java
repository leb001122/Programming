package fifth;

import java.util.Scanner;

public class Shape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Shape Size : ");
        int size = sc.nextInt();

        while(size!=-1)
        {
            for(int line=0; line<size; line++)
            {
                if(line==0 || line==size-1)
                {
                    for(int i=0; i<size; i++)
                        System.out.print("*");
                    System.out.println();
                }
                else
                {
                    System.out.print("*");
                    for(int i=0; i<size-2; i++)
                        System.out.print(" ");
                    System.out.println("*");
                }
            }
            System.out.print("Input Shape Size : ");
            size = sc.nextInt();
        }
    }
}
