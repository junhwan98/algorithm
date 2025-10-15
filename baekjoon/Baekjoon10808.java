package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10808 {
    public static void main(String[] args) throws IOException {
        int[] chars = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }

        for (int c : chars) {
            sb.append(c).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}
