package fourth;

import java.util.Scanner;

public class Operation {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Input Equation (num1 op num2)? ");
            double num1 = sc.nextInt();
            char op = sc.next().charAt(0);
            double num2 = sc.nextInt();
            sc.nextLine();

            if(op == '+')
                System.out.println(num1+" "+op+" "+num2+ " = " + (num1+num2));
            else if(op == '-')
                System.out.println(num1+" "+op+" "+num2+ " = " + (num1-num2));
            else if(op == '*')
                System.out.println(num1+" "+op+" "+num2+ " = " + (num1*num2));
            else if(op == '/')
                System.out.println(num1+" "+op+" "+num2+ " = " + (num1/num2));

            System.out.println("반복 수행? (Yes / No)");

        } while(sc.nextLine().equals("Yes"));

        sc.close();
    }
}
