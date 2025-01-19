import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int size = s.length(); 
        boolean isUpper = true; 
        
        for (int i = 0; i < size; i++) {
            char result = s.charAt(i);

            // 공백을 만나면
            if (result == ' ') {
                answer.append(' ');
                isUpper = true;  // 공백 이후에는 대문자
                continue;  
            }
            
            // 첫 문자가 아니면 소문자로 변환
            if (!isUpper) {
                answer.append(Character.toString(result).toLowerCase());
            } else {
                // 첫 문자는 대문자로 변환
                answer.append(Character.toString(result).toUpperCase());
                isUpper = false; 
            }
        }
        
        return answer.toString(); 
    }
}
