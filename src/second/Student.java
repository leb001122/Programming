package second;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Student {

    static boolean exit = false;
    static final int maxSize = 100;
    static StudentScore[] scores = new StudentScore[maxSize];
    static int sCount = 0;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        do {
            displayMenu();
            System.out.print("메뉴 선택 : ");
            handleMenu(sc.nextInt(), sc);
        }while(!exit);
    }

    public static void displayMenu()
    {
        System.out.println("-------------------");
        System.out.println("메뉴 선택");
        System.out.println("1. 성적 조회 (전체)");
        System.out.println("2. 성적 조회 (개인)");
        System.out.println("3. 성적 입력");
        System.out.println("4. 성적 수정");
        System.out.println("5. 성적 삭제");
        System.out.println("6. 성적 저장");
        System.out.println("7. 읽어오기");
        System.out.println("8. 프로그램 종료");
        System.out.println("-------------------");
    }

    public static void handleMenu(int menu, Scanner sc)
    {
        switch(menu)
        {
            case 1 : retrieveAll(); break;
            case 2 : retrieveIndividual(sc); break;
            case 3 : inputScore(sc); break;
            case 4 : modifyScore(sc); break;
            case 5 : deleteScore(sc); break;
            case 6 : saveFile(); break;
            case 7 : readFile(); break;
            case 8 : exit = true; break;
            default: System.out.println("올바른 메뉴 번호를 입력해주세요.");
        }
    }

    // 전체 조회
    private static void retrieveAll()
    {
        for(int i=0; i<sCount; i++)
        {
            System.out.println(
                    "\n학번 : " + scores[i].getId() +
                    "\n이름 : " + scores[i].getName() +
                    "\n국어 : " + scores[i].getKor() +
                    "\n영어 : " + scores[i].getEng() +
                    "\n수학 : " + scores[i].getMath()
            );
        }
    }

    // 개인별 조회
    private static void retrieveIndividual(Scanner sc)
    {
        System.out.print("학번을 입력하세요. : ");
        int id = sc.nextInt();
        int index = getStudentIndex(id);

        if(index >= 0)
        {
            System.out.println(
                    "학번 : " + scores[index].getId() +
                    "\n이름 : " + scores[index].getName() +
                    "\n국어 : " + scores[index].getKor() +
                    "\n영어 : " + scores[index].getEng() +
                    "\n수학 : " + scores[index].getMath()
            );
        }
        else
        {
            System.out.println("해당 학번의 학생이 존재하지 않습니다.");
        }
    }

    // 성적 입력
    private static void inputScore(Scanner sc)
    {
        int id, kor, eng, math;
        String name;

        System.out.print("학번을 입력하세요. : ");
        id = sc.nextInt();
        int index = getStudentIndex(id);

        if(index >= 0)
        {
            System.out.println("동일한 학번의 성적이 이미 입력되어 있습니다.");
        }
        else
        {
            System.out.print("학생 이름 : ");
            name = sc.next();
            System.out.print("국어 성적 : ");
            kor = sc.nextInt();
            System.out.print("영어 성적 : ");
            eng = sc.nextInt();
            System.out.print("수학 성적 : ");
            math = sc.nextInt();
            scores[sCount] = new StudentScore(id, name, kor, eng, math);
            sCount++;
        }
    }

    // 성적 수정
    private static void modifyScore(Scanner sc)
    {
        int id, kor, eng, math;
        String name;

        System.out.print("학번을 입력하세요. : ");
        id = sc.nextInt();
        int index = getStudentIndex(id);

        if(index >= 0)
        {
            System.out.print("학생 이름 : " + scores[index].getName()
                     + "\n미변경 시 현재값 그대로 입력 : ");
            name = sc.next();
            System.out.print("국어 성적 : " + scores[index].getKor()
                    + "\n미변경 시 현재값 그대로 입력 : ");
            kor = sc.nextInt();
            System.out.print("영어 성적 : " + scores[index].getEng()
                    + "\n미변경 시 현재값 그대로 입력 : ");
            eng = sc.nextInt();
            System.out.print("수학 성적 : " + scores[index].getMath()
                    + "\n미변경 시 현재값 그대로 입력 : ");
            math = sc.nextInt();
            scores[index].setName(name);
            scores[index].setKor(kor);
            scores[index].setEng(eng);
            scores[index].setMath(math);
        }
        else
        {
            System.out.println("해당 학번의 학생이 존재하지 않습니다.");
        }
    }

    // 성적 삭제
    private static void deleteScore(Scanner sc)
    {
        int id;
        System.out.print("학번을 입력하세요. : ");
        id = sc.nextInt();
        int index = getStudentIndex(id);

        if(index >= 0)
        {
            for(int i=index; i<sCount-1; i++)
            {
                scores[i] = scores[i+1];
            }
            sCount--;
            System.out.println("삭제를 완료했습니다.");
        }
        else
        {
            System.out.println("해당 학번의 학생이 존재하지 않습니다.");
        }
    }

    // 성적 저장
    private static void saveFile()
    {
        try
        {
            PrintWriter out = new PrintWriter("c:\\Temp\\student.txt");

            for(int i=0; i<sCount; i++)
            {
                out.print(Integer.toString(scores[i].getId())+" ");
                out.print(scores[i].getName()+" ");
                out.print(Integer.toString(scores[i].getKor())+" ");
                out.print(Integer.toString(scores[i].getEng())+" ");
                out.print(Integer.toString(scores[i].getMath())+" ");
            }
            out.close();
            System.out.println("성공적으로 저장을 마쳤습니다.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // 읽어오기
    private static void readFile()
    {
        try
        {
            FileReader reader = new FileReader("c:\\Temp\\student.txt");
            Scanner sc = new Scanner(reader);

            while(sc.hasNext())
            {
                int id = sc.nextInt();
                String name = sc.next();
                int kor = sc.nextInt();
                int eng = sc.nextInt();
                int math = sc.nextInt();
                System.out.println(
                            "\n학번 : " + id +
                            "\n이름 : " + name +
                            "\n국어 : " + kor +
                            "\n영어 : " + eng +
                            "\n수학 : " + math
                );
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static int getStudentIndex(int id)
    {
        int i;
        for(i=0; i<sCount; i++)
        {
            if(scores[i].getId() == id)
                break;
        }
        if(i == sCount)
            return -1;
        else
            return i;
    }
}

class StudentScore{
    // 필드 선언
    private int id, kor, eng, math;
    private String name;

    // 생성자 정의
    public StudentScore()
    {
        this(0, "", 0, 0, 0);
    }

    public StudentScore(int id, String name, int kor, int eng, int math)
    {
        this.id = id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getKor()
    {
        return kor;
    }

    public int getEng()
    {
        return eng;
    }

    public int getMath()
    {
        return math;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setKor(int kor)
    {
        this.kor = kor;
    }

    public void setEng(int eng)
    {
        this.eng = eng;
    }

    public void setMath(int math)
    {
        this.math = math;
    }

    // 추가 메소드
    public double getAverage()
    {
        return (this.kor + this.eng + this.math) / 3.0;
    }

}
