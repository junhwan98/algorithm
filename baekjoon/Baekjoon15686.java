package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon15686 {
    static int N;  //맵 크기
    static int M;  //최종 치킨집 개수
    static List<int[]> chicken = new ArrayList<>(); //치킨집 좌표
    static List<int[]> house = new ArrayList<>(); //집 좌표
    static List<List<Integer>> comb = new ArrayList<>(); //조합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String s = st.nextToken();
                if (s.equals("1")) {
                    house.add(new int[]{i, j});
                } else if (s.equals("2")) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        combi(0, new ArrayList<>());
        int ret = Integer.MAX_VALUE;
        for (List<Integer> c : comb) {
            int sum = 0;
            for (int[] h : house) {
                int min =Integer.MAX_VALUE;

                for (Integer chi : c) {  // n번째 치킨집
                    min = Math.min(min,distance(h, chicken.get(chi)));

                }

                sum = sum+min;
            }
            ret = Math.min(ret,sum);

        }
        System.out.println(ret);

    }

    public static void combi(int cur, List<Integer> c) {
        if (c.size() == M) {
            comb.add(new ArrayList<>(c));
            return;
        }
        for (int i = cur; i < chicken.size(); i++) {
            c.add(i);
            combi(i + 1, c);
            c.remove(c.size() - 1);
        }
    }

    public static int distance(int[] a, int[] b){
        int x = Math.abs(a[0]-b[0]);
        int y = Math.abs(a[1]-b[1]);
        return x+y;
    }
}

