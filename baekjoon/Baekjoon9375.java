package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon9375 {

    static int N;  //테스트케이스 수
    static int M; // 의상의 수

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
        //테스트케이스 반복
        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();  // 옷 이름
                String type = st.nextToken(); // 옷 종류

                if(map.containsKey(type)){
                    int c = map.get(type)+1;
                    map.put(type,c);
                }
                else{
                    map.put(type, 1);
                }
            }
            int ret= 1;
            for (Integer value : map.values()) {
                ret *= (value+1);
            }

            System.out.println(--ret);
        }
            }
        }
