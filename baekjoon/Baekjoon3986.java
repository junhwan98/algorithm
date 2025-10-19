package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Baekjoon3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        //문자열 개수
        int n = Integer.parseInt(input);

        int count = 0;

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();

            ArrayDeque<Character> stack = new ArrayDeque<>();
            //스택에 문자 하나씩 넣기
            for (char c : chars) {
               if (!stack.isEmpty() && stack.peek().equals(c)) {
                    stack.pop();
                }else stack.push(c);
            }

            if(stack.isEmpty()){
                count++;
            }

        }
        System.out.println(count);


    }
    }
