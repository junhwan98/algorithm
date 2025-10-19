package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon2468 {

    static int N;
    static int max= 0;
    static int[][] map;
    static int[][] visited;
    static final int[] dx = {1,0,-1,0};
    static final int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > max){
                    max = map[i][j];
                }
            }
        }

        int ret = 0;

        for (int i = 0; i < max; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(visited[j][k] == 0 && map[j][k] > i){
                        visited[j][k] =1;
                        count++;
                        dfs(j,k,i);

                    }
                }
            }
            if (count>ret){
                ret = count;
            }
            visited = new int[N][N];


        }

        System.out.println(ret);

    }

    public static void dfs(int y, int x, int r) {
        for (int i = 0; i < 4; i++) {
            int ny = y+ dy[i];
            int nx = x+ dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] <= r) continue;
            if(visited[ny][nx] == 1) continue;

            visited[ny][nx] = 1;
            dfs(ny,nx,r);
        }
    }

}
