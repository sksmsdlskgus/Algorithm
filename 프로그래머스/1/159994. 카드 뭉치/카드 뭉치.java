import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        for(String card1: cards1){
            q1.add(card1);
        }
        
        for(String card2: cards2){
            q2.add(card2);
        }
        
        
        for(int i=0; i<goal.length; i++){
            String word = goal[i];
            
            if(word.equals(q1.peek())){
                q1.poll();
            }else if(word.equals(q2.peek())){
                q2.poll();
            }else{
                return "No";
            }
        }
        
        return "Yes";
    }
}