package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon17298 {

    static int N;  //수열의 수
    static int[] ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ret = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[1] < num) {
                ret[stack.pop()[0]] = num;
            }
            stack.push(new int[]{i, num});

        }

        StringBuilder sb = new StringBuilder();
        for (int i : ret) {
            if (i == 0) i = -1;
            sb.append(i).append(" ");
        }
        System.out.println(String.valueOf(sb).trim());
    }
}
