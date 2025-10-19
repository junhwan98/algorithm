package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4659 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        while(!s.equals("end")){
            if(valid1(s) && valid2(s) && valid3(s)){
                System.out.println("<"+s+"> is acceptable.");
            }
            else{
                System.out.println("<"+s+"> is not acceptable.");
            }
            s= br.readLine();
        }
    }

    public static boolean valid1(String s){

        String[] vowel = {"a","e","i","o","u"};
        for (String c : vowel) {
            if(s.contains(c)){
            return true;
            }
        }
        return false;
    }
    public static boolean valid2(String s){
        int count= 0;

        for (char c : s.toCharArray()) {
            if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u' ){
                if(count>=0) count++;
                else count = 1;
            }
            else{
                if(count>0) count = -1;
                else count--;
            }

            if(count ==-3 || count ==3){
                return false;
            }
        }
        return true;
    }

    public static boolean valid3(String s){
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if(chars[i-1] == chars[i]){
                if(chars[i] != 'e' &&chars[i] != 'o'){
                    return false;
                }
            }
        }

        return true;
    }

}
