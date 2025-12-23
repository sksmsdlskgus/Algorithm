import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        // 신청 금액 d, 예산 budget 
        // 최대 몇개의 부서에 물품을 지원할 수 있는지 return
        
        int max_count = 0;
        
        Arrays.sort(d);
        
        int sum = 0;
        for(int i=0; i<d.length; i++){
            sum += d[i];
            if(sum <= budget){
                max_count++;
                max_count = Math.max(max_count,max_count);
            }else break;
        }
             
        
        return max_count;
    }
}