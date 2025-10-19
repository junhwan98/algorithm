package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon2178 {

    static int M,N;
    static int[][] map;
    static int[][] visited;
    static final int[] dx= {1,0,-1,0};
    static final int[] dy= {0,1,0,-1};



    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       map = new int[N][M];
       visited = new int[N][M];

       //맵 만들기
        for (int i = 0; i <N ; i++) {
            String line = br.readLine();
            for (int j = 0; j <M; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        bfs(0,0);
        System.out.println( (visited[N-1][M-1]));

    }

        static void bfs(int sy, int sx){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sy,sx});
        visited[sy][sx] =1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny= y+ dy[i];
                int nx= x+ dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx>= M || map[ny][nx] == 0) continue;
                if(visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[y][x] +1;
                q.add(new int[]{ny,nx});

            }
        }
        }

}
