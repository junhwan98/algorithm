package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Baekjoon2870 {

    static int N;
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<BigInteger> list = new ArrayList<>();

    N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();


            for (char c : chars) {
                if('0'<= c && c<= '9'){
                    sb.append(c);
                }
                else{
                    if(!sb.isEmpty()){
                        list.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
            if(!sb.isEmpty()){
                list.add(new BigInteger(sb.toString()));
            }

        }

        Collections.sort(list);

        for (BigInteger i : list) {
            System.out.println(i);
        }

    }

}
