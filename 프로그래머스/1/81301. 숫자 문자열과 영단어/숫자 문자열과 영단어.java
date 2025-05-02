import java.util.*;

class Solution {
    public int solution(String s) {
        String[] number = {"zero", "one", "two", "three", "four", 
                   "five", "six", "seven", "eight", "nine"};
        
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<number.length; i++){  
            String word = number[i];
            int index = sb.indexOf(word);
            
            while (index != -1) {
                sb.replace(index, index + word.length(), String.valueOf(i));
                index = sb.indexOf(word);
            }
            
           }
        
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}