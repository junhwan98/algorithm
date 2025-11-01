package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon4179 {


    static int[][] a;
    static int Y;
    static int X;

    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};

    static int count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        a = new int[Y][X];
        Deque<int[]> f1 = new ArrayDeque<>();
        Deque<int[]> f2 = new ArrayDeque<>();
        Deque<int[]> j1 = new ArrayDeque<>();
        Deque<int[]> j2 = new ArrayDeque<>();

        for (int i = 0; i < Y; i++) {

            String s = br.readLine();

            for (int j = 0; j < X; j++) {

                char c = s.charAt(j);

                switch (c) {
                    case '#':
                        a[i][j] = 1;  //벽은 1
                        break;
                    case 'J':
                        a[i][j] = 2;  //지훈은 2
                        j1.add(new int[]{i, j});
                        break;
                    case 'F':
                        a[i][j] = 3;  //불은 3
                        f1.add(new int[]{i, j});
                        break;

                    default: break;
                }

            }

        }

        while(true){
            while (!f1.isEmpty()) {

                int[] p = f1.poll();

                int y = p[0];
                int x = p[1];

                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];

                    if (ny < 0 || nx < 0 || ny >= Y || nx >= X) continue;
                    if (a[ny][nx] == 1 || a[ny][nx] == 3) continue;

                    a[ny][nx] = 3;
                    f2.add(new int[]{ny, nx});

                }
            }
            if (!f2.isEmpty()) {
                f1 = new ArrayDeque<>(f2);
                f2 = new ArrayDeque<>();
            }


            while (!j1.isEmpty()) {

                int[] p = j1.poll();

                int y = p[0];
                int x = p[1];

                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];

                    if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
                        System.out.println(++count);
                        return;
                    }
                    if (a[ny][nx] != 0 ) continue;


                    a[ny][nx] = 2;
                    j2.add(new int[]{ny, nx});
                }

            }
            if (!j2.isEmpty()) {
                count++;
                j1 = new ArrayDeque<>(j2);
                j2 = new ArrayDeque<>();
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }



    }

}