package package1;

import java.io.*;
import java.util.*;

class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class baekjoon_10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] array;
    static boolean [][] visited;
    static Queue<Pair> queue = new LinkedList<>();
    static int N;
    static ArrayList<Pair> list = new  ArrayList<>();
    static int count = 0;
    static char [] rgb;
    static char [] gb;

    public static void main(String [] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        array = new int[N][N];
        visited = new boolean[N][N];
        setArray(array, N);

        //정상
        rgb = new char[]{'R','G','B'};

        for(char c : rgb) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(array[i][j] != c || visited[i][j]) {
                        continue;
                    }
                    Bfs(i, j, c);
                }
            }
        } System.out.print(count+" ");

        // 적록 색약
        count = 0;
        visited = new boolean[N][N];
        gb = new char[] {'G','B'};

        rgb_to_gb(array, N);

        for(char c : gb) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(array[i][j] != c || visited[i][j]) {
                        continue;
                    }
                    Bfs(i, j, c);
                }
            }
        } System.out.println(count);
    }

    public static void setArray(int [][] arr, int n) throws Exception{
        String input;
        for(int i=0; i<N; i++) {
            input = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
    }

    public static void rgb_to_gb(int [][] arr, int n) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(array[i][j] == 'R') {
                    array[i][j] = 'G';
                }

            }
        }
    }

    public static void Bfs(int y, int x, int color) {
        visited[y][x] = true;
        queue.add(new Pair(x,y));

        // 한구역 검사
        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            addList(temp.x, temp.y);

            for(Pair item : list) {
                if(array[item.y][item.x] != color || visited[item.y][item.x])
                    continue;
                visited[item.y][item.x] = true;
                queue.add(new Pair(item.x, item.y));
            }
            list.clear();
        }
        // 한구역 검사 끝나면 count 증가
        count++;
    }

    public static void addList(int x, int y) {
        if(x>0)
            list.add(new Pair(x-1, y));
        if(y>0)
            list.add(new Pair(x, y-1));
        if(x<N-1)
            list.add(new Pair(x+1, y));
        if(y<N-1)
            list.add(new Pair(x, y+1));
    }


}