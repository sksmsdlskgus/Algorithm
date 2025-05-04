import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int gemCount = set.size();
        
        Map<String,Integer> map = new HashMap<>();
        int start =0;
        int end =0;
        int minValue = Integer.MAX_VALUE;
        int[] answer = new int[2]; 
        
        
        while(end < gems.length){
            map.put(gems[end],map.getOrDefault(gems[end],0)+1);
            end ++;
            
            while(map.size() == set.size()){ // 보석이 모두 담겼을 경우
                if(end - start < minValue){
                    minValue = end - start;
                    answer[0] = start +1;
                    answer[1] = end;
                }
                
                map.put(gems[start],map.get(gems[start])-1);
                if(map.get(gems[start])==0){
                    map.remove(gems[start]);
                }
                start ++;
            }  
        }
        
        
        return answer;
    }
}