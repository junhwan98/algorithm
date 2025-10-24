package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1068 {

    static int N;  // 트리의 노드 개수
    static int R;  // 지울 노드
    static int root;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(br.readLine());
        // 0번째 제거할 경우 0반환

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                root = i;
                if(root == R){
                    System.out.println(0);
                    return;
                }
                continue;

            }
            else if (i == R || parent == R) continue;
            list.get(parent).add(i);
        }

        System.out.println(dfs(root));
    }

    public static int dfs(int i) {
        int child = 0;
        int sum = 0;
        for (Integer integer : list.get(i)) {
            child++;
            sum += dfs(integer);
        }
        if(child == 0) return 1;
        else return sum;
    }
}

