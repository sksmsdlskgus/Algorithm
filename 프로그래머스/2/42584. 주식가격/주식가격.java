import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // prices = 초 단위로 기록된 주식가격이 담긴 배열
        // 가격이 떨어지지 않은 기간은 몇 초인지 return 
        Queue <Integer> second = new LinkedList<>();
        int[] answer = new int [prices.length];
        
        // 자신의 인덱스 값에서 전체 순회 하며 자기보다 높거나 같은 숫자가 있다는 카운트 
        // 근데 하락세 보이면 조건 처리 해줘야함
        
        for(int allprice : prices){
            second.offer(allprice); // 큐에 담고
        }
        
        while(!second.isEmpty()){
         for(int i=0; i<prices.length; i++){
               int count = 0;
               int result = second.poll();     
             // System.out.println(result);
              for(int j=i+1; j<prices.length; j++){
                     count ++;                
                  if (prices[i] > prices[j]) { 
                     break;    
                 }
              }
             answer[i] = count ; 
             // System.out.println(Arrays.toString(answer));
            }
         }   
        return answer;
    }
}