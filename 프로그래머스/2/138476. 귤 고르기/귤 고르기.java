import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 귤을 k개 골라 상자 하나에 담아 판매 
        // 서로 다른 종류가 최소일 때의 귤의 종류의 수를 return
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> value = new ArrayList<>(map.values());
        value.sort(Comparator.reverseOrder());
        
        int sum =0;
        int count = 0;
        
        for(int val : value){
            sum += val;
            count++;
            
            if (sum >= k) break; // 귤의 종류를 최소화 하는거라 sum이 넘어도됨 
        }
        
        
        return count;
    }
}