package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader sb= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(sb.readLine());
        // 날씨 개수
        int n = Integer.parseInt(st.nextToken());
        //연속되는 날짜
        int k = Integer.parseInt(st.nextToken());
        // 누적합
        int[] psum = new int[100004];
        st= new StringTokenizer(sb.readLine());


        //누적합
        for (int i = 1; i <= n; i++) {
            int j = Integer.parseInt(st.nextToken());
            psum[i] = psum[i-1]+ j;
        }

        int max= Integer.MIN_VALUE;
        int i= k;
        while(k<=n){
            int sum = psum[k]-psum[k-i];
            if (sum > max){
                max = sum;
            }
            k++;
        }
        System.out.println(max);
    }
        }
