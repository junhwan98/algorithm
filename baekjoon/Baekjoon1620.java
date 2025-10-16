package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 포켓몬 갯수
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        // 문제 개수
        int q = Integer.parseInt(st.nextToken());

        //포켓몬 받기
        Map<String,Integer> map = new HashMap<>();
        Map<Integer,String> rev = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            s = br.readLine();
            map.put(s,i);
            rev.put(i,s);

        }

        //문제
        for (int i = 0; i < q; i++) {
            s= br.readLine();
            if(map.containsKey(s)){
                System.out.println(map.get(s));
            }
            else{
                System.out.println(rev.get(Integer.parseInt(s)));
                    }
                }

            }

        }
