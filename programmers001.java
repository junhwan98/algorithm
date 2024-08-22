package algorithm;

import java.util.TreeSet;

public class programmers001 {
    public int[] solution(String[] operations) {

        int[] answer = {0,0};

        TreeSet<Integer> numbers = new TreeSet<>();
        for(String s : operations){
            if(s.charAt(0) == 'I'){  // 첫 글자가 I일때
                numbers.add(Integer.parseInt(s.substring(2)));  //뒤에있는 문자를 숫자로 변경해서 추가
            }
            else{
                if (numbers.isEmpty()) {  //비어있으면 생략
                    continue;
                }
                else if (s.length() ==3) { // "D 1" 일 때
                    numbers.remove(numbers.last());  //마지막 요소 삭제
                }
                else {
                    numbers.remove(numbers.first());  //첫번째 요소 삭제
                }
            }
        }

        if(numbers.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = numbers.last();
            answer[1] = numbers.first();
        }

        return answer;
    }
}
