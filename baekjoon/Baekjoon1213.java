package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c-'A']++;
        }
        char center = 'a';
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< alphabet.length; i++){
            if(alphabet[i]==0) continue;
            //개수가 홀수면
            if(alphabet[i]%2 == 1){
                //center가 이미 있는지 확인
                if(center == 'a') {
                    center = (char)('A'+ i);
                    alphabet[i]--;
                    for (int j = 0; j < alphabet[i]/2; j++) {
                        sb.append((char) ('A' + i));
                    }
                }
                else {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }

            }
            //짝수일때
            else {
                for (int j = 0; j < alphabet[i]/2; j++) {
                    sb.append((char)('A'+i));

                }
            }

            }

        String rsb = new StringBuilder(sb).reverse().toString();
        if(center != 'a'){
            sb.append(center);
        }

        sb.append(rsb);
        System.out.println(sb);
        }

    }
