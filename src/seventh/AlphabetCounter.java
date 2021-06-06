package seventh;

import java.util.Scanner;

public class AlphabetCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력<최대 100문자> : ");
        String str = sc.nextLine();

        int [] count = new int[26];
        for(int i=0; i<str.length(); i++) {
            count[str.charAt(i)-'a']++;
        }

        System.out.print("찾고자 하는 문자 입력 : ");
        System.out.print("빈도 수 : "+count[sc.next().charAt(0)-'a']);
    }
}
