import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        System.out.println("== HashSet ==");

        HashSet<Object> set1 = new HashSet<>();
        set1.add(1);
        set1.add(1);
        set1.add(1);
        System.out.println("set1 = " + set1);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        set1.remove(1);
        System.out.println("set1 = " + set1);
        System.out.println(set1.size());
        System.out.println(set1.contains(2));

        // 2. 집합 연산
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> b = new HashSet<>(Arrays.asList(2, 4, 6, 8, 10));
        // 교집합
//        a.retainAll(b);
//        System.out.println("교집합 : " + a);

        // 합집합
//        a.addAll(b);
//        System.out.println("합집합 : " + a);

        // 차집합
        a.removeAll(b);
        System.out.println("차집합 : " + a);



    }
}
