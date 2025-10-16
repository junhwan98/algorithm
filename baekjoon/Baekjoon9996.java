package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //횟수
        int n = Integer.parseInt(s);
        // 패턴 입력
        String p = br.readLine();
        // 패턴 앞부분 뒷부분 나누기
        String[] pattern = p.split("\\*");


        for (int i = 0; i < n; i++) {
            s = br.readLine();
            if(s.length()<pattern[0].length()+ pattern[1].length()){
                System.out.println("NE");
                continue;
            }
            String front = s.substring(0,pattern[0].length());
            String back = s.substring(s.length()-pattern[1].length());
            if(pattern[0].equals(front) && pattern[1].equals(back)){
                System.out.println("DA");
            }
            else System.out.println("NE");

        }

    }
}
