import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Queue <Integer> second = new LinkedList<>();
        
        for(int price: prices){
            second.offer(price);
        }
        
        while(!second.isEmpty()){
            for(int i=0; i<prices.length; i++){
                int count=0;
                int result = second.poll();
                
                for(int j=i+1; j<prices.length; j++){                
                 count++;
                 if(prices[i] > prices[j]) {break;}
               }
            
             answer[i] = count;  
          }
        }
        
        
        return answer;
    }
}