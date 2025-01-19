import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String [quiz.length];
        
        for(int i=0; i<quiz.length; i++){
            String[] index = quiz[i].split(" ");
            int x = Integer.parseInt(index[0]);
            String operator =  index[1];
            int y = Integer.parseInt(index[2]);
            int z = Integer.parseInt(index[4]);
           
            boolean isCorrect = false;
            if("+".equals(operator)){
             isCorrect= (x + y == z);
            } else if("-".equals(operator)){
               isCorrect = ( x - y == z);
            }
           answer[i] = isCorrect ? "O" : "X";
        }
            
          
        return answer;
    }
}