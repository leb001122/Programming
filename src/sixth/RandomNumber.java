package sixth;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int ranNum = ran.nextInt(100);
        System.out.println("내가 선택한 숫자를 맞춰 보세요 (0-99)");

        while(true) {
            System.out.print("숫자 입력 : ");
            int userNum = sc.nextInt();

            if(ranNum > userNum)
                System.out.println("내가 선택한 숫자보다 높습니다.");
            else if(ranNum < userNum)
                System.out.println("내가 선택한 숫자보다 낮습니다.");
            else {
                System.out.println("내가 선택한 숫자를 정확하게 맞췄습니다.");
                return;
            }
        }
    }
}
