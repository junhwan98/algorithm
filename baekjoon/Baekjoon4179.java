package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16234 {

    static int N;  //수열의 수
    static int L;  //수열의 수
    static int R;  //수열의 수
    static int[][] a;

    static boolean[][] visited;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};
    static int sum;
    static int count;
    static Deque<int[]> dq;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        a = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;

        while (flag) {
            flag = false;
            visited = new boolean[N][N];



            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dq = new ArrayDeque<>();
                    sum = 0;
                    if(!visited[i][j]){
                        dfs(i,j);
                    }

                    int size = dq.size();

                    if(size >=2){
                        flag = true;
                        int avg = sum / size;
                        for (int[] yx : dq) {
                            a[yx[0]][yx[1]] = avg;
                        }
                    }

                }
            }

            if(flag) count++;
        }


        System.out.println(count);
    }



    static void dfs(int y, int x) {
        dq.add(new int[]{y,x});
        visited[y][x] = true;
        sum += a[y][x];

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[ny][nx]) continue;
            // 1. 인구비교
            int diff = Math.abs(a[y][x] - a[ny][nx]);
            // 1-1. 인구차이가 L명 이상 R명 이하면 국격선 열기
            if (L <= diff && diff <= R) {
                dfs(ny,nx);
            }
        }
    }


}