import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int day = 0;
        int duringDay = 10;
            
        for(int j=0; j<= discount.length - duringDay; j++){
            HashMap<String,Integer> map = new HashMap<>();
            
            for(int i=j; i<j+duringDay; i++){
                map.put(discount[i],map.getOrDefault(discount[i],0)+1);
            }
            
            boolean visited = true;
            for(int i=0; i<want.length; i++){
                String food = want[i];
                int foodCount = number[i];
                
                if(map.getOrDefault(food,0) != foodCount){
                    visited = false;
                    break;
                }
                
            }
            
           if(visited) day++;
               
        }
        
        return day;
    }
}