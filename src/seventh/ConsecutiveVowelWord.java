package seventh;

import java.util.Scanner;

public class ConsecutiveVowelWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("영어 단어 10개 입력");
        String [] array = new String[10];

        for(int i=0; i<10; i++) {
            System.out.print((i+1)+"번째 단어? ");
            array[i] = sc.next();
        }

        System.out.println("연속적 모음을 갖는 단어");
        for(String str : array) {
            int cnt = 0;

            for(int j=0; j<str.length(); j++) {
                char ch = str.charAt(j);
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                    cnt++;
                else
                    cnt=0;

                if(cnt>1) {
                    System.out.println(str);
                    break;
                }
            }
        }
    }
}
