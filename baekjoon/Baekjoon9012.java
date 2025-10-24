package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Baekjoon9012 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : chars) {
                if(stack.isEmpty()){
                    stack.push(c);
                }
                else {
                    if(stack.peek() == '(' && c ==')' ){
                        stack.pop();
                    }
                    else {
                        stack.push(c);
                    }
                }
            }
            if(stack.isEmpty()){
                sb.append("YES").append('\n');
            }
            else {
                sb.append("NO").append('\n');
            }

        }

        System.out.println(sb);
    }

            }

