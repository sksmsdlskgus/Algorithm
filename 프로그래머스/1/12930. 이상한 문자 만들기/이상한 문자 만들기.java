import java.util.*;
class Solution {
    public String solution(String s) {
        // 짝수번째 알파벳은 대문자 
        // 홀수번째 앒파벳은 소문자로 리턴 
        
        StringBuilder sb = new StringBuilder();
        int index =0;
        
        for(int i=0; i<s.length(); i++){    
            char word = s.charAt(i);
            
            if(word == ' '){
                sb.append(' ');
                index =0;
            }else {
                if(index%2 == 0){
                    sb.append(Character.toUpperCase(word));
                }else {
                    sb.append(Character.toLowerCase(word));
                }
                
                index++;
            }

        }

        return sb.toString();
    }
}