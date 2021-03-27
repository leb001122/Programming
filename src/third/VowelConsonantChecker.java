package third;

import java.util.Scanner;

public class VowelConsonantChecker {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input character? ");
        char alphabet = sc.next().charAt(0);

        if(alphabet > 'a' && alphabet < 'z')
            alphabet -= 32;

        switch (alphabet)
        {
            case 'A' : case 'E' : case 'I' : case 'O' : case 'U' :
                System.out.print(alphabet + " is Vowel"); break;
            default : System.out.print(alphabet + " is Consonant");
        }

    }
}
